class Solution {
    public String longestPalindrome(String s) {
        int n = s.length(), maxLen = 1, start = 0;
        Manacher M = new Manacher(s);

        for (int i = 0; i < n; ++i) {
            int oddLen = M.getLongest(i, 1);
            if (oddLen > maxLen) {
                // update start for odd-length palindrome
                start = i - (oddLen - 1) / 2;
            }

            int evenLen = M.getLongest(i, 0);
            if (evenLen > maxLen) {
                // update start for even-length palindrome
                start = i - (evenLen - 1) / 2;
            }

            maxLen = Math.max(maxLen, Math.max(oddLen, evenLen));
        }

        return s.substring(start, start + maxLen);
    }
}


class Manacher {
    // p[i] stores the radius of the palindrome 
    // centered at position i in ms
    int[] p;

    // transformed string with sentinels 
    // and separators
    String ms;

    public Manacher(String s) {
        // left sentinel to avoid bounds check
        StringBuilder sb = new StringBuilder("@");  
        for (char c : s.toCharArray()) {
            
             // insert '#' between every character
            sb.append("#").append(c); 
        }
        // right sentinel
        sb.append("#$");  
        ms = sb.toString();
        runManacher();
    }

    private void runManacher() {
        int n = ms.length();
        p = new int[n];
        int l = 0, r = 0;

        for (int i = 1; i < n - 1; ++i) {
            int mirror = l + r - i;
            if (mirror >= 0 && mirror < n) {
                p[i] = Math.max(0, Math.min(r - i, p[mirror]));
            } else {
                p[i] = 0;
            }

            // try expanding around center i
            while ((i + 1 + p[i]) < n && (i - 1 - p[i]) >= 0 &&
                    ms.charAt(i + 1 + p[i]) == ms.charAt(i - 1 - p[i])) {
                ++p[i];
            }

            // update [l, r] if the new palindrome goes 
            // beyond current right boundary
            if (i + p[i] > r) {
                l = i - p[i];
                r = i + p[i];
            }
        }
    }

    // return the radius of the longest palindrome 
    // centered at original index 'cen'
    public int getLongest(int cen, int odd) {
        int pos = 2 * cen + 2 + (odd == 0 ? 1 : 0);
        return p[pos];
    }

    // checks whether the substring 
    // s[l..r] is a palindrome
    public boolean check(int l, int r) {
        int res = getLongest((r + l) / 2, (r - l + 1) % 2);
        return (r - l + 1) <= res;
    }
}

