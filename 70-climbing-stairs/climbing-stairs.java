class Solution {
    int solve(int n,int[] dp){
        if (n == 1 || n==2) 
            return n;
        if(dp[n]==0)
            dp[n] =solve(n-1,dp) + solve(n-2,dp);
        return dp[n];
    }

    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        return solve(n,dp);    
    }
}