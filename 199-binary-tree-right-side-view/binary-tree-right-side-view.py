# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if root:
            queue = [root]
            resArr = []
            while(queue):
                length = len(queue)
                for i in range(length):
                    curr = queue.pop(0)
                    if curr.left:
                        queue.append(curr.left)
                    if curr.right:
                        queue.append(curr.right)
                    res = curr.val
                resArr.append(res)
            return resArr
        return []
             
