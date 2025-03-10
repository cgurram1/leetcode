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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
        HashMap<TreeNode,TreeNode> parents = new HashMap<>();
        parents.put(root,null);
        dfs(parents,root);
        
        Queue<TreeNode> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        visited.add(target.val);
        queue.add(target);
        int count;
        int nextCount = 1;
        int dist = 0;
        while(dist < k){
            count = nextCount;
            nextCount = 0;
            for(int i = 0;i<count;i++){
                TreeNode popped = queue.poll();
                if(popped.left != null && (visited.contains(popped.left.val) == false)){
                    nextCount+=1;
                    queue.add(popped.left);
                    visited.add(popped.left.val);
                }
                if(popped.right != null && (visited.contains(popped.right.val) == false)){
                    nextCount+=1;
                    visited.add(popped.right.val);
                    queue.add(popped.right);
                }
                if(parents.get(popped) != null && visited.contains(parents.get(popped).val) == false){
                    nextCount+=1;
                    visited.add(parents.get(popped).val);
                    queue.add(parents.get(popped));
                }
            }
            dist++;
        }
        int len = queue.size();
        for(int i = 0;i<len;i++){
            result.add(queue.poll().val);
        }
        return result;
    }
    public void dfs(HashMap<TreeNode,TreeNode> parents, TreeNode root){
        if(root == null){
            return;
        }
        if(root.left != null){
        parents.put(root.left,root);
        dfs(parents,root.left);
        }
        if(root.right != null){
        parents.put(root.right,root);
        dfs(parents,root.right);
        }
        
    }
}