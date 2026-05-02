class Solution {
    int mod = 1000000007;

    public int minNonZeroProduct(int p) {
        if (p == 1) return 1;
        
        // Use 1L to ensure the shift happens in 64-bit space
        long maxVal = (1L << p) - 1; 
        long count = (maxVal - 1) / 2;
        long target = maxVal - 1;
        
        // Calculate (target^count * maxVal) % mod
        long res = power(target % mod, count);
        return (int) ((res * (maxVal % mod)) % mod);
    }

    private long power(long base, long exp) {
        long res = 1;
        base %= mod;
        while (exp > 0) {
            // Explicitly check for parity
            if ((exp & 1) == 1) {
                res = (res * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return res;
    }
}