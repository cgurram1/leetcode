# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        res = None
        count = k
        def fun(node):
            nonlocal count,res
            if not node:
                return
            fun(node.left)
            count-=1
            if count == 0:
                res = node.val
                return
            fun(node.right)
        fun(root)
        return res
        
            