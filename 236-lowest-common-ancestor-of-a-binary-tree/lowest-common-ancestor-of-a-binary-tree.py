# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        def LCA(node):
            if node.val == p.val or node.val == q.val:
                return node

            left = None
            right = None
            if node.left:
                left = LCA(node.left)
            if node.right:
                right = LCA(node.right)
            if left and right:
                return node
            if left or right:
                if left:
                    return left
                return right
            return None
        return LCA(root)