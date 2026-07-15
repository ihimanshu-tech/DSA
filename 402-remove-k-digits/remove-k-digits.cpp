class Solution {
public:
    string removeKdigits(string s, int k) {
        stack<char> stk;
        int n = s.size();
        for (int i = 0; i < n; i++) {
            while (!stk.empty() && stk.top() > s[i] && stk.top() > s[i] &&
                   k > 0) {
                stk.pop();
                k--;
            }
            if (!stk.empty() || s[i] != '0')
                stk.push(s[i]);
        }
        //remove remaining digits 
        while (!stk.empty() && k != 0) {
            stk.pop();
            k--;
        }

        string ans = "";
        while (!stk.empty()) {
            ans += stk.top();
            stk.pop();
        }
        reverse(ans.begin(),ans.end());

        if(ans.empty()) return "0";
    
        return ans;
    }
};