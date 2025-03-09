import java.util.*;

class Pair {
    TreeNode node;
    long index;
    
    public Pair(TreeNode node, long index) {
        this.node = node;
        this.index = index;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        int result = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            long leftIndex = Long.MAX_VALUE;
            long rightIndex = Long.MIN_VALUE;

            for (int i = 0; i < levelSize; i++) {
                Pair popped = queue.poll();
                TreeNode poppedNode = popped.node;
                long poppedIndex = popped.index;

                if (poppedNode.left != null) {
                    queue.add(new Pair(poppedNode.left, 2 * poppedIndex));
                    leftIndex = Math.min(leftIndex, 2 * poppedIndex);
                    rightIndex = Math.max(rightIndex, 2 * poppedIndex);
                }
                if (poppedNode.right != null) {
                    queue.add(new Pair(poppedNode.right, 2 * poppedIndex + 1));
                    leftIndex = Math.min(leftIndex, 2 * poppedIndex + 1);
                    rightIndex = Math.max(rightIndex, 2 * poppedIndex + 1);
                }
            }

            if (rightIndex != Long.MIN_VALUE && leftIndex != Long.MAX_VALUE) {
                result = Math.max(result, (int) (rightIndex - leftIndex + 1));
            }
        }

        return result;
    }
}
