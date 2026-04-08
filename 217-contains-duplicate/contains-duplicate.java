import java.util.HashSet;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        // Use a HashSet to keep track of numbers we've seen
        HashSet<Integer> seen = new HashSet<>();
        
        for (int num : nums) {
            // If the number is already in the set, we found a duplicate
            if (seen.contains(num)) {
                return true;
            }
            // Otherwise, add it to the set
            seen.add(num);
        }
        
        // If we finish the loop, all numbers are unique
        return false;
    }
}