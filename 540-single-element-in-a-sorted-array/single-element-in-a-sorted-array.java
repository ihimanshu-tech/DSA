class Solution {
    public int singleNonDuplicate(int[] nums) {
        int curr = 0;
        for(int i= 0;i<nums.length;i++){
            curr = curr ^ nums[i];
        }
        return curr;
    }
}