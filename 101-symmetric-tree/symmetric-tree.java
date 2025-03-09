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
    public boolean isSymmetric(TreeNode root) {
        return rec(root.left,root.right);
    }
    public boolean rec(TreeNode rootL, TreeNode rootR){
        if(rootL == null && rootR == null){
            return true;
        }
        else if(rootL == null || rootR == null){
            return false;
        }
        if(rootL.val == rootR.val && rec(rootL.left,rootR.right) && rec(rootL.right,rootR.left)){
            return true;
        }
        return false;
    }
}