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
    int widthOfBinaryTree(TreeNode* root){   
        if(!root) return 0;
        int width = 0;
        queue<pair<TreeNode*,long long>> q;
        q.push({root,0});

        while(!q.empty()){
            int n = q.size();
            long long min_id = q.front().second; //to make it starting form zero
            int first =0,last =0;

            for(int i=0;i<n;i++){

                long long curr_id = q.front().second - min_id;
                TreeNode* node = q.front().first;
                q.pop();

                if(i==0) first = curr_id;
                if(i==n-1) last = curr_id;

                if(node->left)
                    q.push({node->left,curr_id*2+1});

                if(node->right)
                    q.push({node->right,curr_id*2 +2});
            }
            width = max(width,last-first+1);
        }
        return (int)width;
    }
};










