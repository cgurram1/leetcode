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
            result = max(result, max(node.val, max(node.val + leftSum, max(node.val + rightSum,node.val + rightSum + leftSum))))
            maxV = max(leftSum,rightSum)
            returnVal = max(node.val,node.val + maxV)
            if returnVal > 0:
                return returnVal
            return 0

        REC(root)
        return result