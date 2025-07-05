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
        if(fun(root) == -1){
            return false;
        }
        return true;
    }
    public int fun(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = fun(node.left);
        int right = fun(node.right);
        if(left == -1 || right == -1 || left - right > 1 || left - right < -1){
            return -1;
        }
        return Math.max(left,right) + 1;
    }
}