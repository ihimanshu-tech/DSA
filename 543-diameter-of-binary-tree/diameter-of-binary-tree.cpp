/**
 * Definition for a binary tree node.
 * struct TreeNode {
 * int val;
 * TreeNode *left;
 * TreeNode *right;
 * TreeNode() : val(0), left(nullptr), right(nullptr) {}
 * TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 * TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    int diameterOfBinaryTree(TreeNode* root) {
        int maxDiameter = 0;
        calculateHeight(root, maxDiameter);
        return maxDiameter;
    }

private:
    int calculateHeight(TreeNode* node, int& maxDiameter) {
        if (node == nullptr) {
            return 0;
        }

        // Recursively find the height of left and right subtrees
        int leftHeight = calculateHeight(node->left, maxDiameter);
        int rightHeight = calculateHeight(node->right, maxDiameter);

        // Update the maximum diameter found so far
        maxDiameter = std::max(maxDiameter, leftHeight + rightHeight);

        // Return the height of the current node's subtree
        return 1 + std::max(leftHeight, rightHeight);
    }
};