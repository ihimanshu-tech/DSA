class Solution {
    public boolean halvesAreAlike(String s) {
        int n = s.length();
        int diff = 0;
        String vowels = "aeiouAEIOU";
        
        for (int i = 0; i < n / 2; i++) {
            // Check first half (increment)
            if (vowels.indexOf(s.charAt(i)) != -1) diff++;
            // Check second half (decrement)
            if (vowels.indexOf(s.charAt(i + n / 2)) != -1) diff--;
        }
        
        return diff == 0;
    }
}