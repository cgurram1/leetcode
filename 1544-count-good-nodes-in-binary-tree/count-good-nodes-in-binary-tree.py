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
    def goodNodes(self, root: TreeNode) -> int:
        def REC(node,stack):
            if node == None:
                return 0
            recns = 0
            if not stack or node.val >= stack[-1]:
                recns = 1
                stack.append(node.val)
            recns+=REC(node.left,stack) + REC(node.right,stack)
            if stack[-1] == node.val:
                stack.pop()
            return recns

        return REC(root,[])

