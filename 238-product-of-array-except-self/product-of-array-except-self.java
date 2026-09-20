class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int[] ls = new int[n];
        int[] rs = new int[n];

        ls[0] = 1;
        rs[n-1] = 1;
        for(int i=n-2;i>=0;i--){
            rs[i] = rs[i+1] * nums[i+1];
        }
        for(int i=1;i<n;i++){
            ls[i] = ls[i-1] * nums[i-1];
        }
        for(int i=0;i<n;i++){
            ans[i] = ls[i] * rs[i];
        }
        return ans;
    }
}