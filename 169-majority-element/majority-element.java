
class Solution {
    public int majorityElement(int[] nums) {

        int ele = 0;
        int cnt = 0;
        for(int i = 0; i < nums.length; i++){
            if(cnt ==0){
                // cnt = 1; // if count will be equal to 1 and last pairing off will be canceled and answer can be wrong 
                ele = nums[i];
            }
            if(nums[i] == ele){
                cnt++;
            }
            else {
                cnt--;
            }
        }
        return ele;
     
    }
}