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
    TreeNode result = null;
    int maxDepth = 0;

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        maxDepth = getMaxDepth(root);
        helper(root, 0);
        return result;
    }

    private int getMaxDepth(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(getMaxDepth(node.left), getMaxDepth(node.right));
    }

    private int helper(TreeNode node, int depth) {
        if (node == null) return depth;

        int left = helper(node.left, depth + 1);
        int right = helper(node.right, depth + 1);

        // If both left and right reach the deepest level
        if (left == maxDepth && right == maxDepth) {
            result = node;  // This is the lowest common ancestor of deepest leaves
        }

        return Math.max(left, right);
    }
}