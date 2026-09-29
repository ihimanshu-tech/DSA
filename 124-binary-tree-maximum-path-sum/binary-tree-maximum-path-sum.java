/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = Math.max(0, dfs(node.left)); //0 is returned to avoid negative value
        int right = Math.max(0, dfs(node.right));

        // Path passing through current node
        maxSum = Math.max(maxSum,
                left + node.val + right);

        // Path that parent can continue
        return node.val + Math.max(left, right);
    }
}