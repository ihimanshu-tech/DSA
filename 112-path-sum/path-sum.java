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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        //if root is null
        if(root==null) return false;

        Stack<TreeNode> path = new Stack<>();
        Stack<Integer> sumSt = new Stack<>();
        
        path.push(root); // [5]
        sumSt.push(root.val);//[5]

        while(!path.isEmpty()){
            
            TreeNode temp = path.pop();
            int tempVal =sumSt.pop();
            //if it's leaf temp
            if(temp.left ==null && temp.right ==null && tempVal == targetSum){
                return true;
            }

            if(temp.left!=null){
                path.push(temp.left);
                sumSt.push(temp.left.val + tempVal);//[5,9,20,27]
            }
            if(temp.right!=null){
                path.push(temp.right);
                sumSt.push(temp.right.val +tempVal); //[5,13,17,18]
            }
        }
        return false;
    }
}