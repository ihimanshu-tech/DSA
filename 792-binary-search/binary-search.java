class Solution {
    public int search(int[] nums, int target) {
        // Start the recursion with the full range of the array
        return helper(nums, target, 0, nums.length - 1);
    }

    private int helper(int[] nums, int target, int left, int right) {
        // Base case: If the search range is empty, the target isn't here
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;

        if (nums[mid] == target) {
            return mid; // Found it!
        } else if (nums[mid] > target) {
            // Search the left half
            return helper(nums, target, left, mid - 1);
        } else {
            // Search the right half
            return helper(nums, target, mid + 1, right);
        }
    }
}