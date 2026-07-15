class Solution {
public:
    string reverseWords(string s) {
        
        stack<string> stk;
        int n = s.size();
        for (int i = 0; i < n; i++) {
            if (s[i] == ' ')
                continue;
            string temp;
            while (i<n && s[i] != ' ' ) {
                temp += s[i];
                i++;
            }
            stk.push(temp);
        }
        string ans;
        while(!stk.empty()){
            ans = ans+ stk.top() + " ";
            stk.pop();
        }
        ans.pop_back();
        return ans;
    }
};