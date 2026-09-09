class Solution {
public:
    int singleNumber(vector<int>& nums) {
        int my_xor=0;
        for(int i=0;i<nums.size();i++){
            my_xor ^= nums[i];
        }
        return my_xor;
    }
};