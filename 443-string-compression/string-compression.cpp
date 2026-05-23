class Solution {
public:
    int compress(vector<char>& chars) {
        int n = chars.size();
        int index = 0;  // write pointer

        for (int i = 0; i < n; ) {
            char current = chars[i];
            int count = 0;

            // count frequency
            while (i < n && chars[i] == current) {
                i++;
                count++;
            }

            // write character
            chars[index++] = current;

            // write count if > 1
            if (count > 1) {
                string cnt = to_string(count);
                for (char c : cnt) {
                    chars[index++] = c;
                }
            }
        }

        return index;
    }
};