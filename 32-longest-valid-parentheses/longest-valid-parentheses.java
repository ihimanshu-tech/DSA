class Solution {
    public int longestValidParentheses(String s) {
        int left = 0;
        int right = 0;
        int maxLength = 0;
        
        // Pass 1: Left to Right
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                left++;
            } else {
                right++;
            }
            
            if (left == right) {
                maxLength = Math.max(maxLength, 2 * right);
            } else if (right > left) {
                // More closing brackets than opening brackets breaks validity
                left = 0;
                right = 0;
            }
        }
        
        left = 0;
        right = 0;
        
        // Pass 2: Right to Left (catches leftover open brackets like "(()")
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch == '(') {
                left++;
            } else {
                right++;
            }
            
            if (left == right) {
                maxLength = Math.max(maxLength, 2 * left);
            } else if (left > right) {
                // More opening brackets than closing brackets breaks validity
                left = 0;
                right = 0;
            }
        }
        
        return maxLength;
    }
}
