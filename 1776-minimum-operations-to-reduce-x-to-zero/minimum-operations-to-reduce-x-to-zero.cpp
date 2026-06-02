class Solution {
public:
    int minOperations(vector<int>& arr, int x) {
        int totalSum = 0;
        int operations = -1;
        int n = arr.size();
        for(int i :arr){
            totalSum +=i;
        }
        int reqSum = totalSum -x;
        
        int winSum = 0;
        int left =0, right =0;
        while(right<n){
                winSum+=arr[right];
                while(left<=right && winSum>reqSum){
                    winSum -= arr[left];
                    left++;
                }
                if(winSum == reqSum){
                    operations = max((right -left +1),operations);
                }
                right++;
        }

        return operations == -1 ? -1 :n-operations;
    }
};