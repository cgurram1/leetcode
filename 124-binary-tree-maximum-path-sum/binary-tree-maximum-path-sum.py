# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        result = float('-inf')
        def REC(node):
            nonlocal result
            if node == None:
                return 0
            leftSum = REC(node.left)
            rightSum = REC(node.right)
            if leftSum < 0:
                leftSum = 0
            if rightSum < 0:
                rightSum = 0
            result = max(result, node.val + rightSum + leftSum)
            return node.val + max(leftSum,rightSum)

        REC(root)
        return result