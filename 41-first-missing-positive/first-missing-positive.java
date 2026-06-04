class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n;i++){
            while( nums[i]>0 &&
                nums[i]<=n &&
                nums[i] != nums[nums[i]-1]
            ){
            int cind = nums[i] -1;
            //swap
            int temp = nums[i];
            nums[i] = nums[cind];
            nums[cind] = temp;
            }
            
        }
        for(int i=0;i<n;i++){
            if(i+1 !=nums[i]) return i+1;
        }  
        return n +1;      
    }
}