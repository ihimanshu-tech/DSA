class Solution {
    public boolean find132pattern(int[] nums) {
        if(nums == null || nums.length<3){
            return false;
        }
        int numK = Integer.MIN_VALUE;
        Stack<Integer> st = new Stack<>(); 
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]<numK){
                return true;
            }
            while(!st.isEmpty() && nums[i]>st.peek()){
                numK = st.pop();
            }
            st.push(nums[i]);
        }
        return false;
    }
}