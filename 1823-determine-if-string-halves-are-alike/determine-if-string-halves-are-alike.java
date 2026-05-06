class Solution {
    public boolean halvesAreAlike(String s) {
        int n = s.length();
        int count = 0;
        
        // One loop to handle both halves
        for (int i = 0; i < n / 2; i++) {
            if (isVowel(s.charAt(i))) count++;
            if (isVowel(s.charAt(i + n / 2))) count--;
        }
        
        return count == 0;
    }

    // A helper method is often cleaner and slightly faster than long || chains
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
               c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}