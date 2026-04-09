import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);  // Step 1: Sort array
        List<List<Integer>> list = new ArrayList<>();
        int n = nums.length;

        // Step 2: Fix first element (i)
        for (int i = 0; i < n - 2; i++) {

            // Skip duplicate values for i
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;        // second pointer
            int right = n - 1;       // third pointer

            // Step 3: Two pointer traversal
            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {

                    // Found valid triplet
                    list.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicates for left
                    while (left < right && nums[left] == nums[left + 1]) left++;

                    // Skip duplicates for right
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    // Move both pointers
                    left++;
                    right--;

                } else if (sum < 0) {
                    // Need bigger sum → move left forward
                    left++;
                } else {
                    // Need smaller sum → move right backward
                    right--;
                }
            }
        }

        return list;
    }
}