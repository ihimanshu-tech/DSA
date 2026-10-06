class Solution {
    public int longestCommonSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length(); 
        int[][] dp  = new int[n+1][m+1];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        return solve(s,t,0,0, dp);
    } 
    private int solve(String s, String t, int i, int j, int[][] dp){
        int n = s.length();
        int m = t.length();
        if(dp[i][j] != -1) return dp[i][j];

        if(i>= n || j>= m) return 0;

        if(s.charAt(i) == t.charAt(j))
            return dp[i][j] = 1 + solve(s,t,i+1,j+1,dp);
        else
            return dp[i][j] = Math.max(solve(s,t,i+1,j,dp), solve(s,t,i,j+1,dp));
    }       
}
