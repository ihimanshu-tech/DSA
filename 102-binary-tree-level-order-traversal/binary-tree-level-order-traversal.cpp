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
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        if(root ==nullptr) return {};
        vector<vector<int>> ans;
        queue<TreeNode*> q;
        q.push(root);
        while(!q.empty()){
            int n = q.size();
            vector<int> tmp;
            while(n){
                TreeNode* curr = q.front();
                // curr ko root de diya // queue se nikaal kar
                q.pop();
                tmp.push_back(curr->val);
                if(curr->left!=nullptr){
                    q.push(curr->left);
                    //queue se 
                }
                if(curr->right!=nullptr){
                    q.push(curr->right);
                    //queue se 
                }

                n--;
            }
            ans.push_back(tmp);
        }
        return ans;
    }
};