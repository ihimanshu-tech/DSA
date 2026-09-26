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

    int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        return inorder(root, k);
    }

    private int inorder(TreeNode node, int k) {

        if (node == null) {
            return -1;
        }

        int left = inorder(node.left, k);

        if (left != -1) {
            return left;
        }

        count++;

        if (count == k) {
            return node.val;
        }

        return inorder(node.right, k);
    }
}