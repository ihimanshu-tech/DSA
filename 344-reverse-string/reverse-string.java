class Solution {
    public void reverseString(char[] s) {
        helper(s, 0, s.length - 1);
    }

    private void helper(char[] s, int left, int right) {
        // Base case: when pointers meet or cross
        if (left >= right) {
            return;
        }

        // Swap characters at the current pointers
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;

        // Recursive call moving pointers inward
        helper(s, left + 1, right - 1);
    }
}