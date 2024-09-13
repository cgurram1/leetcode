# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        def inOrder(node,res):
            if node == None:
                return None
            inOrder(node.left,res)
            res.append(node.val)
            if len(res) == k:
                return
            inOrder(node.right,res)
        res = []
        inOrder(root,res)
        return res[k-1]