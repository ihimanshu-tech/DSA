class Solution {
public:
    vector<int> nextGreaterElements(vector<int>& nums) {
        stack<int> st;
        int n = nums.size();
        vector<int> ans(n,-1);
        for(int i=n*2-1;i>=0;i--){
            while(!st.empty() && st.top()<=nums[i%n]){
                st.pop();
            }
            ans[i%n] = st.empty() ? -1 :st.top(); 
            st.push(nums[i%n]);
        }
        return ans;
    }
};