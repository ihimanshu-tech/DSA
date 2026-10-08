class Solution {
    public String compressedString(String word) {
        int n = word.length();
        StringBuilder comp = new StringBuilder();
        
        for (int i = 0; i < n; ) {
            char current = word.charAt(i);
            int count = 0;
            
            while (i < n && word.charAt(i) == current && count < 9) {
                i++;
                count++;
            }
            comp.append(count).append(current);
        }
        
        return comp.toString();
    }
}