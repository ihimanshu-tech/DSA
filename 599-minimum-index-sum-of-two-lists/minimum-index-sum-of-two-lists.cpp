class Solution {
public:
    vector<string> findRestaurant(vector<string>& list1, vector<string>& list2) {
        unordered_map<string, int> visMap;
        vector<string> res;

        for (int i = 0; i < list1.size(); i++) 
            visMap[list1[i]] = i;

        int minsum = INT_MAX;
        
        for(int i = 0 ;i<list2.size();i++){
            if(visMap.count(list2[i])){
                int sum = i + visMap[list2[i]];
                if(sum<minsum){
                    minsum = sum;
                    res.clear();
                    res.push_back(list2[i]);
                }
                else if(sum==minsum) res.push_back(list2[i]);
            }
        }
        return res;
    }
};