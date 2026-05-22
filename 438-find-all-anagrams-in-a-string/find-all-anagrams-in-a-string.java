import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        
        // Edge case: If p is longer than s, s cannot contain any anagrams of p
        if (s.length() < p.length()) {
            return result;
        }

        // Frequency arrays for p (v1) and the sliding window in s (v2)
        int[] v1 = new int[26];
        int[] v2 = new int[26];

        // 1. Build the frequency array for string p
        for (int i = 0; i < p.length(); i++) {
            v1[p.charAt(i) - 'a']++;
        }

        // 2. Start sliding the window across string s
        for (int i = 0; i < s.length(); i++) {
            // Add the current letter to the window
            v2[s.charAt(i) - 'a']++;

            // Once the window exceeds the exact size of p, 
            // remove the oldest letter (leftmost) from the window
            if (i >= p.length()) {
                int leftCharIdx = s.charAt(i - p.length()) - 'a';
                v2[leftCharIdx]--;
            }

            // If the window is exactly the size of p, check if frequencies match
            if (i >= p.length() - 1) {
                if (Arrays.equals(v1, v2)) {
                    // If they match, add the starting index of this window
                    result.add(i - p.length() + 1);
                }
            }
        }

        return result;
    }
}