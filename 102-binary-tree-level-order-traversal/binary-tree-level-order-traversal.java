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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> outerList = new ArrayList<>();
        if(root == null){
            return outerList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while(queue.size() > 1){
            List<Integer> innerList = new ArrayList<>();
            while(queue.peek() != null){
                TreeNode i = queue.poll();
                innerList.add(i.val);
                if(i.left != null){
                    queue.add(i.left);
                }   
                if(i.right != null){
                    queue.add(i.right);
                }
            }
            queue.add(queue.poll());
            outerList.add(innerList);
        }
        return outerList;
    }
}