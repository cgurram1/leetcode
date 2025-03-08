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
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        int diff = depth(root.left) - depth(root.right);
        if(diff < -1 || diff > 1 || isBalanced(root.left) == false || isBalanced(root.right) == false){
            return false;
        }
        return true;
    }
    public int depth(TreeNode root){
        if(root == null){
            return 0;
        }
        return 1 + Math.max(depth(root.left),depth(root.right));
    }
}