import java.util.*;
class Solution {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);        
        // Step 2: Initialize a counter for distinct elements
        // We start at 1 because the very last element is always the 1st maximum
        int distinctCount = 1;
        // Step 3: Iterate backwards starting from the second-to-last element
        for (int i = nums.length - 1; i > 0; i--) {
            // Only increment count if the current number is different from the next one
            if (nums[i] != nums[i - 1]) {
                distinctCount++;
            }
            
            // As soon as we hit the 3rd distinct number, return it
            if (distinctCount == 3) {
                return nums[i - 1];
            }
        }
        // Step 4: If we exit the loop, there weren't 3 distinct numbers
        // Return the first maximum (the last element in the sorted array)
        return nums[nums.length - 1];
    }
}