class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtracker(nums, 0, ans);
        return ans;
    }
    public void backtracker(int[] nums, int idx, List<List<Integer>> ans) {
        if(idx == nums.length) {
            List<Integer> arr = new ArrayList<>(); 
            for(int n : nums) {
                arr.add(n);
            }
            ans.add(arr);
            return;
        }
        for(int i = idx; i < nums.length; i++) {
            swap(nums, i, idx);
            backtracker(nums, idx + 1, ans);
            swap(nums, i, idx);
        }
    }
    public void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}