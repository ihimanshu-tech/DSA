class Solution {
    int result = 0;

    public int countArrangement(int n) {
        int[] nums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            nums[i] = i; // Fix: Assign the values
        }
        dfs(nums, n); // Start from n and go down to 1
        return result;
    }

    void dfs(int[] nums, int val) {
        // Base case: if we've successfully placed all numbers down to 1
        if (val == 0) {
            result++;
            return;
        }

        for (int i = val; i > 0; i--) {
            swap(nums, i, val);
            
            // Check if the number we just put at index 'val' is "beautiful"
            // The condition: (number % index == 0) OR (index % number == 0)
            if (nums[val] % val == 0 || val % nums[val] == 0) {
                dfs(nums, val - 1);
            }
            
            swap(nums, i, val); // Backtrack
        }
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}