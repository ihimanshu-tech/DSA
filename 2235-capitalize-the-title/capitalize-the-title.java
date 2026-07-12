class Solution {
    public String capitalizeTitle(String title) {
        char[] ch = title.toLowerCase().toCharArray();
        int n = ch.length;
        int start = 0;
        
        for (int i = 0; i <= n; i++) {

            if (i == n || ch[i] == ' ') {
                int wordLength = i - start;
                

                if (wordLength > 2) {
                    ch[start] = Character.toUpperCase(ch[start]);
                }
                
                start = i + 1;
            }
        }
        
        return new String(ch);
    }
}