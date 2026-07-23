# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        res = []
        def fun(node):
            if node.left:
                fun(node.left)
            res.append(node.val)
            if len(res) == k:
                return
            if node.right:
                fun(node.right)
        fun(root)
        print(res)
        return res[k-1]
        
            