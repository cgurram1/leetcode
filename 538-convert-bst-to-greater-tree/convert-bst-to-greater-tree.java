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
    public TreeNode convertBST(TreeNode root) {
        if(root != null){
            fun(root,0);
        }
        return root;
    }
    public int fun(TreeNode root, int send){
        if(root.left == null && root.right == null){
            root.val += send;
            return root.val;
        }
        if(root.right != null){ 
        root.val = root.val + fun(root.right,send);
        }
        else{
            root.val += send;
        }
        if(root.left != null){
            return fun(root.left,root.val);
        }
        return root.val;
    }
}