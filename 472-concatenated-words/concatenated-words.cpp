class Solution {
public:
    vector<string> findAllConcatenatedWordsInADict(vector<string>& words) {
        unordered_set<string> st(words.begin(), words.end());
        vector<string> result;

        for (const string& word : words) {
            if (word.empty()) continue;
            
            // Temporarily remove the current word so it doesn't match itself as a single word
            st.erase(word);
            
            if (canForm(word, st)) {
                result.push_back(word);
            }
            
            // Put it back for other words to use
            st.insert(word);
        }

        return result;
    }

private:
    bool canForm(const string& word, const unordered_set<string>& st) {
        int n = word.length();
        vector<bool> dp(n + 1, false);
        dp[0] = true; // Base case: empty prefix

        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (dp[j] && st.count(word.substr(j, i - j))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
};