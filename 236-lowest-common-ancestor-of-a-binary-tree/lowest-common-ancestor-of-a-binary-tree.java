/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return rec(root,p,q);
    }
    public TreeNode rec(TreeNode curr, TreeNode p, TreeNode q){
        if(curr == null){
            return null;
        }
        if(curr == p || curr == q){
            return curr;
        }
        TreeNode left = rec(curr.left,p,q);
        TreeNode right = rec(curr.right,p,q);
        if(left != null && right != null){
            return curr;
        }
        else if(left!= null){
            return left;
        }
        else if(right != null){
            return right;
        }
        return null;
        
    }
}