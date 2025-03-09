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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> listP = new ArrayList<>();
        List<TreeNode> listQ = new ArrayList<>();
        rec(root,p,listP);
        rec(root,q,listQ);
        int minLen = Math.min(listP.size(), listQ.size());
        int i = 0;
        TreeNode res = null;
        while(i < minLen && listP.get(i).val == listQ.get(i).val){
            res = listP.get(i);
            i++;
        }
        return res;
    }
    public boolean rec(TreeNode curr, TreeNode p, List<TreeNode> listP){
        if(curr == null){
            return false;
        }
        if(curr.val == p.val){
            listP.add(curr);
            return true;
        }
        listP.add(curr);
        if( rec(curr.left,p,listP) || rec(curr.right,p,listP)){
            return true;
        }
        listP.remove(listP.size()-1);
        return false;
    }
}