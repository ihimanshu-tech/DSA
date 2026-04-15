import java.util.Arrays;

class Solution {
    public int largestPerimeter(int[] nums) {
        // Sort the array in ascending order
        Arrays.sort(nums);
        
        // Iterate backwards starting from the largest side lengths
        // A triangle is valid if a + b > c (where c is the longest side)
        for (int i = nums.length - 3; i >= 0; i--) {
            if (nums[i] + nums[i + 1] > nums[i + 2]) {
                // The first valid triangle we find will have the largest perimeter
                return nums[i] + nums[i + 1] + nums[i + 2];
            }
        }
        
        // If no triangle can be formed, return 0
        return 0;
    }
}