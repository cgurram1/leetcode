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

class Pair{
    TreeNode node;
    long index;
    public Pair(TreeNode node, long index){
        this.node = node;
        this.index = index;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        Queue<Pair> queue = new LinkedList<>(); 
        long leftIndex;
        long rightIndex;
        int result = 0;
        queue.add(new Pair(root,0));
        queue.add(null);
        while(queue.size() > 1){
            // for (Pair p : queue) {
            //     if(p != null){
            //         System.out.println("Node: " + p.node.val + ", Index: " + p.index);
            //     }
            // }
            // System.out.println("-------------------------");
            leftIndex = Long.MAX_VALUE;
            rightIndex = Long.MIN_VALUE;
            while(queue.peek() != null){
                Pair popped = queue.poll();
                TreeNode poppedNode = popped.node;
                long poppedIndex = popped.index;
                if(poppedNode.left != null){
                    queue.add(new Pair(poppedNode.left, 2 * poppedIndex));
                    leftIndex = Math.min(leftIndex,2 * poppedIndex);
                    rightIndex = Math.max(rightIndex, 2 * poppedIndex);
                }
                if(poppedNode.right != null){
                    queue.add(new Pair(poppedNode.right, 2 * poppedIndex + 1));
                    leftIndex = Math.min(leftIndex,2 * poppedIndex + 1);
                    rightIndex = Math.max(rightIndex, 2 * poppedIndex + 1);
                }
            }
            // System.out.println(leftIndex + " " + rightIndex);
            queue.add(queue.poll());
            if(rightIndex == Long.MIN_VALUE && leftIndex == Long.MAX_VALUE){
                continue;
            }
            else{
                result = Math.max(result, (int)(rightIndex - leftIndex + 1));
            }
        }
        return result;
    }
}