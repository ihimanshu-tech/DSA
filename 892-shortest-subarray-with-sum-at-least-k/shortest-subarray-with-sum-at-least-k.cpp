class Solution {
public:
    int shortestSubarray(vector<int>& nums, int k) {
        int n= nums.size();
        vector<long long> prefix(n+1,0);
        int ans = n+1;
        deque<int> dq;
        //prefix sum
        for(int i=0;i<n;i++){
            prefix[i+1] = prefix[i] + nums[i];
        }
        long long target = k;

        for (int i=0;i<=n;i++){
        //MAINTAINING queue for indexes            
            while(!dq.empty() && prefix[i] - prefix[dq.front()] >=target){
                ans = min(ans,i-dq.front());
                dq.pop_front();
            }
            while(!dq.empty() && prefix[i] <= prefix[dq.back()]){
                // ans = min(ans,i-dq.front());
                dq.pop_back();
            }

            dq.push_back(i);
        }
        return ans == n+1? -1 : ans ;
    }
};