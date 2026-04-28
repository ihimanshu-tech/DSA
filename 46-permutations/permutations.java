import java.util.ArrayList;
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> perm = new ArrayList<>();
        helper(nums, perm, ans);
        return ans;
    }
    void helper(int[] nums, List<Integer> perm, List<List<Integer>> ans){
        // Base case
        if (perm.size() == nums.length) {
            ans.add(new ArrayList<>(perm));
            return;
        }
        for (int j = 0; j < nums.length; j++){
            if (perm.contains(nums[j])) continue; // AVoid Duplicates
            perm.add(nums[j]); 
            helper(nums,perm,ans);
            perm.remove(perm.size() - 1);  // Backtrack
        }
    }
}