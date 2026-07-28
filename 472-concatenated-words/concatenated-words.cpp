class Solution {
    unordered_map<string,bool> mp;

    bool isConcatenated(string word, unordered_set<string> &st) {

        if(mp.find(word) != mp.end())
            return mp[word];
        int l = word.length();
        for (int i = 0; i < l; i++) {
            string prefix = word.substr(0, i + 1);
            string suffix = word.substr(i + 1);

            // 1. Check if prefix exists AND suffix is either in set or can be recursively formed
            if (st.find(prefix) != st.end() && (st.find(suffix) != st.end() || isConcatenated(suffix, st))) {
                return mp[word] = true;
            }
        }
        return mp[word] = false;
    }

public:
    vector<string> findAllConcatenatedWordsInADict(vector<string>& words) {
        int n = words.size();
        unordered_set<string> st(begin(words), end(words));
        vector<string> result;

        for (int i = 0; i < n; i++) {
            string word = words[i];
            if (word.empty()) continue;

            // 2. Erase current word so it doesn't match itself
            // st.erase(word);

            if (isConcatenated(word, st))
                result.push_back(word);

            // Re-insert after checking
            st.insert(word);
        }
        return result;
    }
};