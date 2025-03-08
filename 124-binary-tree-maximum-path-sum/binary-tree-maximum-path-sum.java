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
    public int maxPathSum(TreeNode root) {
        int [] res = new int[1];
        res[0] = Integer.MIN_VALUE;
        rec(root,res);
        return res[0];
    }
    public int rec(TreeNode root,int [] res){
        if(root == null){
            return 0;
        }
        int left = rec(root.left,res);
        int right = rec(root.right,res);
        if(left < 0){
            left = 0;
        }
        if(right < 0){
            right  = 0;
        }
        res[0] = Math.max(res[0], root.val + left + right);
        return root.val + Math.max(left,right);
    }

}