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
    public TreeNode invertTree(TreeNode root) {
        fun(root);
        return root;
    }
    public void fun(TreeNode node){
        if(node != null){
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            fun(node.left);
            fun(node.right);
        }
    }
}