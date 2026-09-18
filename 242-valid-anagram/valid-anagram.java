class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        HashMap<Character,Integer> mp = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char chars =s.charAt(i);
            char chart =t.charAt(i);
            mp.put(chars,mp.getOrDefault(chars,0) + 1);
            mp.put(chart,mp.getOrDefault(chart,0) - 1);
        }
        for(int count :mp.values()){
            if(count !=0) return false;
        }
        return true;
    }
}