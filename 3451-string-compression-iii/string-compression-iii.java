class Solution {
    public String compressedString(String word) {
        int  n = word.length();
        String comp = "";
        for(int i =0;i<n;){
            char current = word.charAt(i);
            int count = 0;
            while(i<n && current== word.charAt(i) && count <=8){
                i++;
                count++;
            }
            String cnt = String.valueOf(count);
            for(int j= 0;j<cnt.length();j++){
                comp = comp + cnt.charAt(j);
            }
            comp = comp + current;
        }
        return comp;
    }
}