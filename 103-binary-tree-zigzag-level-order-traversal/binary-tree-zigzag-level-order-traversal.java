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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        int i = 0;
        
        while(queue.size() > 1){
            List<Integer> innerList = new ArrayList<>();
            Stack<Integer> stack = new Stack<>();
            while(queue.peek() != null){
                TreeNode popped = queue.poll();
                if(i%2 == 0){
                    innerList.add(popped.val);
                }
                else{
                    stack.push(popped.val);
                }
                if(popped.left != null){
                    queue.add(popped.left);
                }
                if(popped.right != null){
                    queue.add(popped.right);
                }
            }
            i++;
            while(stack.isEmpty() == false){
                innerList.add(stack.pop());
            }
            result.add(innerList);
            queue.add(queue.poll());
        }
        return result;
    }
}