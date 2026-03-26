# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        def REC(node,left,right):
            if node == None:
                return True
            if left < node.val < right:
                if not REC(node.left,left,node.val) or not REC(node.right,node.val,right):
                    return False
                return True
            else:
                return False
        return REC(root,float('-inf'),float('inf'))