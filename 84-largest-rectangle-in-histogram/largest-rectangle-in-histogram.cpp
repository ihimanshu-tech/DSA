class Solution {
    vector<int> leftMin(vector<int> &arr){
        int n= arr.size();
        vector<int> leftMinIndex(n);
        stack<int> st;
        for(int i=0;i<n;i++){
            while(!st.empty() && arr[st.top()] >=arr[i]){
                st.pop();
            }
            leftMinIndex[i] = st.empty() ? -1:st.top();
            st.push(i);
        }
        return leftMinIndex;
    }
    vector<int> rightMin(vector<int> &arr){
        int n= arr.size();
        vector<int> rightMinIndex(n);
        stack<int> st;
        for(int i=n-1;i>=0;i--){
            while(!st.empty() && arr[st.top()] >=arr[i]){
                st.pop();
            }
            rightMinIndex[i] = st.empty() ? n:st.top();
            st.push(i);
    }
    return rightMinIndex;
}

public:
    int largestRectangleArea(vector<int>& h) {
        int n = h.size();
        int maxArea = 0;
        vector<int> leftMinIndex = leftMin(h);
        vector<int> rightMinIndex = rightMin(h);

        // right or left ke difference se width aayegi
        //smallest element jo nikla hai unke liye end ke idhar udhar jaayege jo sahi widhth claculate ho 
        //left wala -1 index hoga and right ke liye nth index hogi
        for(int i=0;i<n;i++){
                int width = rightMinIndex[i] - leftMinIndex[i] -1;
                int area = width*h[i];
                maxArea = max(area,maxArea);
        }
        return maxArea;
    }
};