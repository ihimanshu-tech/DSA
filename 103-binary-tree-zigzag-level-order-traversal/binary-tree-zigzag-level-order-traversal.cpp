#include <vector>
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
    int height(TreeNode* root){
        if(root==nullptr) return 0;
        return max(height(root->left), height(root->right)) +1 ;
    }
    void leftToRight(TreeNode* root,int level, vector<int> &temp){
        if(root==nullptr) return;

        if(level==1){
            temp.push_back(root->val);
            return;
        }
        leftToRight(root->left,level-1,temp);
        leftToRight(root->right,level-1,temp);
    }
    void rightToLeft(TreeNode* root,int level, vector<int> &temp){
        if(root==nullptr) return;

        if(level==1){
            temp.push_back(root->val);
            return;
        }
        rightToLeft(root->right,level-1,temp);
        rightToLeft(root->left,level-1,temp);
    }
public:
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
        int level = height(root);
        vector<vector<int>> ans;
        bool reverse = false;
        for(int i=1;i<=level;i++){
            vector<int> temp;
            if(reverse == false)
                leftToRight(root,i,temp);
            else
                rightToLeft(root,i,temp);
            ans.push_back(temp);
            reverse = !reverse;
        }
        return ans;
    }
};