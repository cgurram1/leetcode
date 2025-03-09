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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        rec(root,result,new StringBuilder());
        return result;
    }
    public void rec(TreeNode root, List<String> result, StringBuilder path){
        if(root == null){
            return;
        }
        int len = path.length(); 
        path.append(root.val);
        if(root.left == null && root.right == null){
            result.add(path.toString());
            path.setLength(len);
            return;
        }
        path.append("->");
        rec(root.left,result,path);
        rec(root.right,result,path);
        path.setLength(len);
    }
}