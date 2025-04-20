class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        dfs(root, 0, new ArrayList<>(), result, targetSum);
        return result;
    }

    private void dfs(TreeNode node, int currentSum, List<Integer> path, List<List<Integer>> result, int targetSum) {
        path.add(node.val);
        currentSum += node.val;

        // Leaf node check
        if (node.left == null && node.right == null) {
            if (currentSum == targetSum) {
                result.add(new ArrayList<>(path));  // snapshot the path
            }
        } else {
            if (node.left != null) {
                dfs(node.left, currentSum, path, result, targetSum);
            }
            if (node.right != null) {
                dfs(node.right, currentSum, path, result, targetSum);
            }
        }

        path.remove(path.size() - 1); // backtrack
    }
}
