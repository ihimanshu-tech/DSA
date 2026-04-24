import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // Step 1: Sort the array to use the two-pointer technique
        Arrays.sort(nums);
        int n = nums.length;
        int minDiff = Integer.MAX_VALUE;
        int resultSum = 0;
        for (int i = 0; i < n - 2; i++) {
        int left = i + 1;        // second pointer
        int right = n - 1;       // third pointer
        while (left < right) {
            int sum = nums[i] + nums[left] + nums[right];
            if (sum == target) return target;
            if (sum < target) left++;
            else right--;

            int diffToTarget = Math.abs(sum - target);
            if (diffToTarget < minDiff) {
                resultSum = sum;
                minDiff = diffToTarget;
            }
        }
    }
    return resultSum;    
    }
}