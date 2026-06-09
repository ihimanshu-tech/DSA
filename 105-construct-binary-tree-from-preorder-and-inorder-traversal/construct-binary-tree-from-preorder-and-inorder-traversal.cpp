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
    TreeNode* treeBanao(unordered_map<int, int> &map,vector<int>& inorder, int inSt, int inEnd,
    vector<int>& preorder,int preSt,int preEnd){
        if(preSt > preEnd || inSt>inEnd){
            return nullptr;
        }
        TreeNode* root = new TreeNode(preorder[preSt]);
        int rootIndex = map[preorder[preSt]];
        int leftSize = rootIndex - inSt;
        root->left  = treeBanao(map,inorder,inSt ,rootIndex -1, preorder ,preSt +1,preSt+leftSize); //left Subtree
        root->right = treeBanao(map,inorder,rootIndex +1, inEnd, preorder ,preSt+leftSize +1,preEnd ); //right Subtree
        return root;

    }
public:
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        unordered_map<int, int> map;
        for(int i =0;i<inorder.size();i++){
            map[inorder[i]] = i;
        }
        return treeBanao(map,inorder,0,inorder.size()-1,preorder,0,preorder.size()-1);
    }
};