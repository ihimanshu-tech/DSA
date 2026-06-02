class Solution {
public:
    int maxIceCream(vector<int>& arr, int coins) {
        int n = arr.size();
        int maxEle = *max_element(arr.begin(),arr.end());
        vector<int> freq(maxEle +1);
        for(int i:arr){
            freq[i]++;
        }
        int count = 0;
        for(int i=0;i<=maxEle ;i++){
            while(freq[i]>0 && coins >=i){
                count++;
                freq[i]--;
                coins -= i;
            }
        }
        return count;
    }
};