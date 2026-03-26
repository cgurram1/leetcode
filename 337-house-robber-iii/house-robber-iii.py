# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rob(self, root: Optional[TreeNode]) -> int:
        def REC(node,parentPicked):
            if node == None:
                return 0
            if (node,parentPicked) in dp:
                return dp[(node,parentPicked)]
            robbed = 0
            norobbed = 0
            if parentPicked == False:
                robbed = node.val + REC(node.left,True) + REC(node.right,True)
            norobbed = REC(node.left,False) + REC(node.right,False)
            dp[(node,parentPicked)] = max(robbed, norobbed)
            return dp[(node,parentPicked)] 
        dp = {}
        return REC(root,False)