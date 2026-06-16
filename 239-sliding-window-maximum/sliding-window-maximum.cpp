class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& arr, int k) {
        int n = arr.size();
        int l = 0;
        int r = 0;
        deque<int> dq;
        vector<int> ans;
        while(r<n){
            while(!dq.empty() && dq.front()<l){
                dq.pop_front();
            }
            while(!dq.empty() && arr[dq.back()] < arr[r]){
                dq.pop_back();
            }
            dq.push_back(r);
            if(r-l+1 == k){
                ans.push_back(arr[dq.front()]);
                l++;
            }
            r++;
        }
        return ans;
    }
};   