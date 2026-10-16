class Solution {
    int count = 0; // Fixed: Move count to a class variable so updates persist across recursive calls

    public int countSubstrings(String s) {
        count = 0;
        // Fixed: Use a visited matrix to stop infinite recursion and prevent double counting
        boolean[][] visited = new boolean[s.length() + 1][s.length() + 1];
        
        solve(s, 0, s.length(), visited);
        return count;
    }

    void solve(String s, int i, int j, boolean[][] visited) {
        // Base Case: If the indices cross or are invalid, stop
        if (i >= j) return;
        
        // Base Case: If we have already evaluated this specific substring, return immediately
        if (visited[i][j]) return;
        visited[i][j] = true; // Mark as visited

        // Check if the current substring is a palindrome
        if (palin(s, i, j)) {
            count++;
        }

        // Fixed: Recursive calls that narrow down the window properly
        solve(s, i + 1, j, visited); // Shift left pointer right
        solve(s, i, j - 1, visited); // Shift right pointer left
    }

    boolean palin(String s, int i, int j) {
        int left = i;
        int right = j - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
