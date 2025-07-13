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
    public int res = 0;
    public int distributeCoins(TreeNode root) {
        fun(root);
        return res;
    }
    public int[] fun(TreeNode root){
        if(root.left == null && root.right == null){
            res+= Math.abs(root.val - 1);
            return new int[]{root.val,1};
        }
        int [] left = new int[]{0,0};
        int [] right = new int[]{0,0};
        if(root.left != null){
            left = fun(root.left);
        }
        if(root.right!= null){
            right = fun(root.right);
        }
        res+= Math.abs(left[0] + right[0] + root.val - (left[1] + right[1] + 1));
        return new int[]{left[0] + right[0] + root.val, left[1] + right[1] + 1};
    }
}