class Solution {
    public int[] findErrorNums(int[] nums) {
        int duplicate = -1;
        int missing = -1;

        // 1. Find the duplicate using sign inversion
        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]);
            if (nums[val - 1] < 0) {
                duplicate = val;
            } else {
                nums[val - 1] *= -1;
            }
        }

        // 2. Find the missing number (the index that remains positive)
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                missing = i + 1;
            }
        }

        return new int[]{duplicate, missing};
    }
}