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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        
        fun(root, new ArrayList<>(Arrays.asList(root.val)), root.val,result,targetSum);
        return result;
    }
    public void fun(TreeNode node, List<Integer> path, int sum, List<List<Integer>> result, int targetSum){
        // System.out.println(sum);
        if(node.left == null && node.right == null){
            if(sum == targetSum){
                result.add(new ArrayList<>(path));
            }
            return;
        }
        if(node.left != null){
            path.add(node.left.val);
            fun(node.left,path,sum+node.left.val,result,targetSum);
            path.remove(path.size()-1);
        }
        if(node.right != null){
            path.add(node.right.val);
            fun(node.right,path,sum+node.right.val,result,targetSum);
            path.remove(path.size()-1);
        }
    }
}