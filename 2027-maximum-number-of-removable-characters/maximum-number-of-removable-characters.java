class Solution {
    public int maximumRemovals(String s, String p, int[] removable) {
        char[] sChars = s.toCharArray();
        char[] pChars = p.toCharArray();
        
        int low = 0, high = removable.length;
        int ans = 0;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (isPossible(sChars, pChars, removable, mid)) {
                ans = mid;    // This k works, save it
                low = mid + 1; // Try to remove more
            } else {
                high = mid - 1; // Too many removed, try less
            }
        }
        return ans;
    }

    private boolean isPossible(char[] s, char[] p, int[] removable, int k) {
        boolean[] removed = new boolean[s.length];
        for (int i = 0; i < k; i++) {
            removed[removable[i]] = true;
        }
        
        int sp = 0, pp = 0;
        while (sp < s.length && pp < p.length) {
            if (!removed[sp] && s[sp] == p[pp]) {
                pp++;
            }
            sp++;
        }
        return pp == p.length;
    }
}