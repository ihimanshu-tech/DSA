class Solution {
    private long MOD = 1_000_000_007;

    public int countGoodNumbers(long n) {
        long odd = n / 2;
        long even = n / 2 + n % 2;
        
        // Calculate (5^even * 4^odd) % MOD
        long total = (power(5, even) * power(4, odd)) % MOD;
        
        return (int) total;
    }

    public long power(long x, long n) {
        if (n == 0) return 1;
        
        long res = power(x, n / 2);
        res = (res * res) % MOD;
        
        if (n % 2 != 0) {
            res = (res * x) % MOD;
        }
        
        return res;
    }
}