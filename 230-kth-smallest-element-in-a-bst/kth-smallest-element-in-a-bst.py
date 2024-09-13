# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    count = 0
    result = 0
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        def inOrder(node):
            if node == None:
                return
            inOrder(node.left)
            self.count+=1
            if self.count == k:
                self.result = node.val
                return
            inOrder(node.right)
        inOrder(root)
        return self.result