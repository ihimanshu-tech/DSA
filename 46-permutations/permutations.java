import java.util.ArrayList;
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        solve(nums, 0 ,res);
        return res;
    }
    public void solve(int[] nums,int idx, List<List<Integer>> res){
        if(idx == nums.length){
            List<Integer> temp = new ArrayList<>();
            for(int n:nums){
                temp.add(n);
            }
            res.add(temp);
            return;
        }
        for(int i= idx;i<nums.length;i++){
            swap(nums,i,idx);
            solve(nums,idx+1,res);
            swap(nums,i,idx);
        }
    }

    public void swap(int[] nums ,int a ,int b){
        int temp  = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}