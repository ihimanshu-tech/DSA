class Solution {
    public List<String> restoreIpAddresses(String s) {
       ArrayList<String> res = new ArrayList<>();
        solve(s,0,"",0,res);
        return res;
    }
    private void solve(String s, int index,String curr, int parts, ArrayList<String> res){
        if(parts==4 && index==s.length()){
            res.add(curr.substring(0,curr.length() -1));
            return;
        }
        
        if(parts==4 || index==s.length()) 
            return;
        
        for(int i = 1; i<=3 && index+i<=s.length();i++){
            
            String part = s.substring(index,index +i);
            if(part.length() >1 && part.charAt(0) =='0') 
                continue;
            
            int num = Integer.parseInt(part);
            if(num<=255){
                solve(s,index+i, curr+part+'.',parts+1,res);
            }
        }
    }
}