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
        rec(root);
        return root;
    }
    public void rec(TreeNode root){
        if(root == null){
            return;
        }
        TreeNode temp = new TreeNode();
        temp = root.right;
        root.right = root.left;
        root.left = temp;
        rec(root.right);
        rec(root.left);
    }
}