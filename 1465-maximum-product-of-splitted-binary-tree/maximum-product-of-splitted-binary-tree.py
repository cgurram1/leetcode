# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxProduct(self, root: Optional[TreeNode]) -> int:
        def total(root):
            if(root == None):
                return 0
            return root.val + total(root.left) + total(root.right)
        totalSum = total(root)
        result = 0
        def dfs(node):
            nonlocal result
            if(node == None):
                return 0
            left = dfs(node.left)
            right = dfs(node.right)
            sumNode = node.val + left + right
            result = max(result, (totalSum - sumNode) * sumNode)
            return sumNode
        dfs(root)
        return result % (10**9 + 7)
        
            