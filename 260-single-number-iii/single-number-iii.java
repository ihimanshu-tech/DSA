class Solution {
    public int[] singleNumber(int[] nums) {
        int xorr = 0;
        for(int val : nums){
            xorr^=val;
        }
        xorr &= -xorr;
        // long int rightmost = (xorr & xorr-1)^xorr;
        int[] res ={0,0};
        for(int val : nums){
            if((val & xorr) == 0)
                res[0] ^= val;
            else
                res[1] ^= val;
        }

        return res;
    }
}