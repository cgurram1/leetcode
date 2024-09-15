# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def hasPathSum(self, root: Optional[TreeNode], targetSum: int) -> bool:
        def myRec(curr,res):
            #Base
            #Body
            if curr == None:
                return False
            res = res + curr.val
            if curr.left == None and curr.right == None:
                if res == targetSum:
                    return True
                return False
            return (myRec(curr.left,res) or myRec(curr.right,res))
        temp = root
        return myRec(temp,0)