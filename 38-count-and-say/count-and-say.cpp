class Solution {
public:
    string countAndSay(int n) {
        string result = "1";
        for (int i= 1;i<n;i++){
            string next_str = "";
            int cnt = 1;
            for (int j= 1;j<result.length();j++){
                if(result[j] == result[j-1])
                    cnt++;
                else{
                    next_str += to_string(cnt) + result[j-1];
                    cnt = 1;
                }
            }
            next_str += to_string(cnt) + result.back();
            result = next_str;
            }
        return result;
    }
};