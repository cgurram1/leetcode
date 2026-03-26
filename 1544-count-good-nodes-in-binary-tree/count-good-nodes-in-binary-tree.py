# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

"""
                                    3
                                5
                            10      14
                        8       3    
                    2       6    
                        
[3,5]

"""
class Solution:
    def goodNodes(self, root):
        def REC(node, maxSoFar):
            if not node:
                return 0

            count = 1 if node.val >= maxSoFar else 0

            maxSoFar = max(maxSoFar, node.val)

            count += REC(node.left, maxSoFar)
            count += REC(node.right, maxSoFar)

            return count

        return REC(root, float('-inf'))

