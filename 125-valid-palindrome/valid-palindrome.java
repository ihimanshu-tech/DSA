class Solution {
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() -1 ;
        s = s.toLowerCase();
        while (start < end) {
                        // skip non-alphanumeric
            while (start < end && !Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            }

            while (start < end && !Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            }
            
            if (s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}