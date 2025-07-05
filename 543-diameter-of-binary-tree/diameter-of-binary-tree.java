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
    int res = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        fun(root);
        return res;
    }

    public int fun(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = fun(node.left);
        int right = fun(node.right);
        res = Math.max(res,left + right);
        return Math.max(left,right) + 1;
    }
}