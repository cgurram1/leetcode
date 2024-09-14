# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return [] 
        queue = [root]
        # levelOrder = []
        right = []
        while(queue):
            length = len(queue)
            arr = []
            for i in range(length):
                popped = queue.pop(0)
                arr.append(popped.val)
                if popped.left:
                    queue.append(popped.left)
                if popped.right:
                    queue.append(popped.right)
            right.append(arr[-1])
        # print(levelOrder)
        return right
