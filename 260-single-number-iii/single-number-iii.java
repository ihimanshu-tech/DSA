class Solution {
    public int[] singleNumber(int[] nums) {
        int xorr = 0;
        for(int val : nums){
            xorr^=val;
        }
        int mask = xorr & -xorr;
        
        int[] res ={0,0};
        for(int val : nums){
            if((val & mask) == 0)
                res[0] ^= val; //group A
            else
                res[1] ^= val; //group B
        }
        return res;
    }
}
// xorr will give xorr of that two single number
// mask of 2's complement will give rightmost set bit(1)
// group A will contain a single number along with duplicate numbers
// group B will contain another single number along with different duplicate numbers