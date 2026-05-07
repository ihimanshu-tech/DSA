class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        // Base case: if the last character is not '0', we can never reach it
        if (s.charAt(n - 1) == '1') {
            return false;
        }

        boolean[] reachable = new boolean[n];
        reachable[0] = true;
        int reachableCount = 0;

        for (int i = 1; i < n; i++) {
            // 1. Add to window: This index 'i' can be reached by a '0' 
            // that is minJump distance behind it.
            if (i >= minJump && reachable[i - minJump]) {
                reachableCount++;
            }

            // 2. Remove from window: Any '0' that is more than maxJump 
            // distance behind 'i' is now out of reach.
            if (i > maxJump && reachable[i - maxJump - 1]) {
                reachableCount--;
            }

            // 3. Check reachability: If current char is '0' and we have 
            // at least one reachable '0' in our window, mark current as true.
            if (s.charAt(i) == '0' && reachableCount > 0) {
                reachable[i] = true;
            }
        }

        // The answer is whether the last index was ever marked reachable
        return reachable[n - 1];
    }
}