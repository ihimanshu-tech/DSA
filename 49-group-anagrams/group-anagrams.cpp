class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        vector<vector<string>> ans;
        unordered_map<string,vector<string>> mp;
        for(auto &x: strs){
            vector<int> count(26, 0);
            for(auto c: x){
                count[c-'a']++;
            }
            string key = "";
            for(int i=0;i<26;i++){
                key+= "#" + to_string(count[i]);
            }
            mp[key].push_back(x);
        }
        for(auto& pair:mp){
            ans.push_back(move(pair.second));
        }
        return ans;
    }
};