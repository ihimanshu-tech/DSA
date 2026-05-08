class Solution {
    public boolean isSubsequence(String t, String s) {
        int sp = 0, pp = 0;
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        while (sp < sChars.length && pp < tChars.length) {
           if (sChars[sp] == tChars[pp]) {
                pp++;
            }
            sp++;
        } 
        return pp == tChars.length; 
        }

}