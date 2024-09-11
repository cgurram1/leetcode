# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def searchBST(self, root: Optional[TreeNode], val: int) -> Optional[TreeNode]:
        def myRec(node):
            #Base
            if node == None:
                return None
            #Body
            if node.val == val:
                return node
            leftRes = myRec(node.left)
            rightRes = myRec(node.right)
            if leftRes:
                return leftRes
            elif rightRes:
                return rightRes
            return None
        return myRec(root)
        