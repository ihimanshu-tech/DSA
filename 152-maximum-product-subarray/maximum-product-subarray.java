class Solution {
    static int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
    static int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
    public int maxProduct(int[] nums) {
        int currMax = nums[0];
        int currMin = nums[0];
        int maxProd = nums[0];
        for(int i=1;i<nums.length;i++){
            int temp = max(nums[i],nums[i]*currMax,nums[i]*currMin);
            currMin = min(nums[i],nums[i]*currMax,nums[i]*currMin);
            currMax = temp;
            maxProd = Math.max(maxProd,currMax);
        }
        return maxProd;
    }
}
// [2][3] = 6 6*-2 = < 6 