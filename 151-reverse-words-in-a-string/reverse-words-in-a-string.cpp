class Solution {
public:
    string reverseWords(string s) {

        // Remove extra spaces
        string temp;
        int i = 0;

        while (i < s.length()) {
            while (i < s.length() && s[i] == ' ')
                i++;

            if (i >= s.length())
                break;

            if (!temp.empty())
                temp += ' ';

            while (i < s.length() && s[i] != ' ') {
                temp += s[i];
                i++;
            }
        }

        s = temp;

        // Reverse entire string
        reverse(s, 0, s.length());

        // Reverse every word
        int left = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s[i] == ' ') {
                reverse(s, left, i);
                left = i + 1;
            }
        }

        // Reverse last word
        reverse(s, left, s.length());

        return s;
    }

private:
    void reverse(string& s, int left, int right) {

        while (left < right - 1) {
            swap(s[left], s[right - 1]);
            left++;
            right--;
        }
    }
};