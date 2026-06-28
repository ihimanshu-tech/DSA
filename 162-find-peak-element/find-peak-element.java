class Solution {
    public int findPeakElement(int[] nums) {
        return peak(nums, 0, nums.length - 1);
    }

    static int peak(int[] nums, int lo, int hi) {
        if (lo == hi)
            return lo;
        int mid = lo + (hi - lo) / 2;
        if (nums[mid + 1] > nums[mid])
            return peak(nums, mid + 1, hi);
        else
            return peak(nums, lo, mid);
    }
}