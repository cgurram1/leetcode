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
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        int count = 0;
        while(queue.size() > 1){
            List<Integer> list = new ArrayList<>();
            while(queue.peek() != null){
                TreeNode curr = queue.poll();
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
                list.add(curr.val);
            }
            queue.add(queue.poll());
            count+=minSwaps(list.stream().mapToInt(Integer::intValue).toArray());
        }
        return count;
    }
    public int minSwaps(int arr[]) {
        // Code here
        int [] temp = new int[arr.length];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<arr.length;i++){
            temp[i] = arr[i];
            map.put(temp[i],i);
        }
        Arrays.sort(temp);
        int count = 0;
        int curr = 0;
        while(curr < arr.length){
            if(map.get(temp[curr]) == curr){
                curr+=1;
            }
            else{
                int t = temp[curr];
                temp[curr] = temp[map.get(t)];
                temp[map.get(t)] = t;
                count+=1;
            }
        }
        return count;
    }
}