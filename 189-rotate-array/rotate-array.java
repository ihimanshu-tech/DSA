class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // Handles cases where k is greater than array length
        
        // 1. Initialize the temp array with correct size
        int[] temp = new int[n];
        
        // 2. Place every element at its new shifted index in temp
        for (int i = 0; i < n; i++) {
            temp[(i + k) % n] = nums[i];
        }
        
        // 3. Copy the elements from temp back into nums
        for (int i = 0; i < n; i++) {
            nums[i] = temp[i];
        }
    }
}