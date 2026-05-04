# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        maxValue = float('-inf')
        def fun(node):
            nonlocal maxValue
            if node == None:
                return float('-inf')
            left = fun(node.left)
            right = fun(node.right)
            maxValue = max(maxValue, max(max(max(node.val, node.val + left), node.val + right), node.val + left + right))
            return max(node.val, node.val + max(left,right))
        fun(root)
        return maxValue
