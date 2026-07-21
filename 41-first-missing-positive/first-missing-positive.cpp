class Solution {
public:
    int firstMissingPositive(vector<int>& nums) {
        sort(nums.begin(),nums.end());
        int n = nums.size();
        int idx = 0;
        for(int i =0;i<n;i++){
            if(nums[i]> 0){
                idx = i;
                break;
            }
        }
        int sum  = 0;
        int count = 1;
        
        for (int i = idx ;i<n;i++){
            if (i > idx && nums[i] == nums[i - 1]) {
                continue;
            }
            if(nums[i] == count)
                count++;
            else if(nums[i]> count) {
                return count;
            }
        }
        return count;
    }
};