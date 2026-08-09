class Solution {
public:
    bool canPartition(vector<int>& nums) {
        int totalSum=0;
        for(int i =0;i<nums.size() ;i++){
            totalSum += nums[i];
        }
        if(totalSum%2!=0) return false;

        int target = totalSum/2;
        vector<bool> dp(target + 1,false);
        dp[0] = true;
        for(int num:nums){
            for(int j = target;j>=num;j--){
                if(dp[j-num]){
                    dp[j]= true;
                }
            }
        }
        return dp[target];
    }
};