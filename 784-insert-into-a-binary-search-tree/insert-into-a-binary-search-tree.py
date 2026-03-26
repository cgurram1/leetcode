# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def insertIntoBST(self, root: Optional[TreeNode], val: int) -> Optional[TreeNode]:
        queue = deque()
        queue.append(root)
        if root == None:
            return TreeNode(val)
        while queue:
            popped = queue.popleft()
            if val < popped.val:
                if popped.left == None:
                    popped.left = TreeNode(val)
                    return root
                queue.append(popped.left)
            else:
                if popped.right == None:
                    popped.right = TreeNode(val)
                    return root
                queue.append(popped.right)
