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
    vector<vector<int>> closestNodes(TreeNode* root, vector<int>& queries) {
        vector<int> temp;
        vector<vector<int>> ans;
        sortedTree(root,temp);
        for(int i=0;i<queries.size();i++){
            int target = queries[i];
            int l = 0;
            int h = temp.size()-1;
            int cmin = -1;
            int cmax = -1;
        
            while(l<=h){
                int m = l +(h-l)/2;
                if(temp[m]==target){
                    cmin = temp[m];
                    cmax = temp[m];
                    break;
                }
                else if(temp[m]<target){
                    cmin = temp[m];
                    l=m+1;
                }
                else{
                    cmax = temp[m];
                    h= m-1;
                }
            }
            ans.push_back({cmin,cmax});
        }    
        return ans;  
    }
    void sortedTree(TreeNode* root,vector<int>& temp){
        if(root==nullptr) return;        
        sortedTree(root->left,temp);
        temp.push_back(root->val);
        sortedTree(root->right,temp);
    }
};