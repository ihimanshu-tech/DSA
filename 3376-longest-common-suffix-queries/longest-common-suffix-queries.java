class Solution {
    // Lightweight TrieNode to prevent Memory Limit Exceeded (MLE)
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int bestIndex = -1; 
    }

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        TrieNode root = new TrieNode();

        // 1. Find the absolute best word (shortest length, earliest index) 
        // to act as the default answer for the root node (empty suffix matches).
        int globalBestIndex = 0;
        for (int i = 1; i < wordsContainer.length; i++) {
            if (wordsContainer[i].length() < wordsContainer[globalBestIndex].length()) {
                globalBestIndex = i;
            }
        }
        root.bestIndex = globalBestIndex;

        // 2. Build the Trie backwards
        for (int i = 0; i < wordsContainer.length; i++) {
            String word = wordsContainer[i];
            TrieNode curr = root;
            int len = word.length();
            
            // Traverse the string from right to left (suffix to prefix)
            for (int j = len - 1; j >= 0; j--) {
                int charIdx = word.charAt(j) - 'a';
                
                if (curr.children[charIdx] == null) {
                    curr.children[charIdx] = new TrieNode();
                    // First word to reach this new node is currently the best
                    curr.children[charIdx].bestIndex = i;
                } else {
                    // Node exists. Update bestIndex if the current word is strictly shorter.
                    // (If lengths are equal, we don't update because 'i' goes from 0 to N-1,
                    // meaning the existing index is already the smaller/earlier one).
                    int prevBest = curr.children[charIdx].bestIndex;
                    if (len < wordsContainer[prevBest].length()) {
                        curr.children[charIdx].bestIndex = i;
                    }
                }
                curr = curr.children[charIdx];
            }
        }

        // 3. Answer the queries
        int[] ans = new int[wordsQuery.length];
        for (int i = 0; i < wordsQuery.length; i++) {
            String query = wordsQuery[i];
            TrieNode curr = root;
            
            // Traverse the Trie backwards for the query
            for (int j = query.length() - 1; j >= 0; j--) {
                int charIdx = query.charAt(j) - 'a';
                if (curr.children[charIdx] == null) {
                    break; // Suffix match ends here
                }
                curr = curr.children[charIdx];
            }
            // Record the pre-calculated best index at the deepest matched node
            ans[i] = curr.bestIndex;
        }

        return ans;
    }
}