# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        res = []
        if root == None:
            return []
        Q = [root]
        nextCount = 1
        while(len(Q) > 0):
            count = nextCount
            nextCount = 0
            currRes = []
            for i in range(count):
                currItem = Q.pop(0)
                currRes.append(currItem.val)
                if currItem.left != None:
                    Q.append(currItem.left)
                    nextCount+=1
                if currItem.right != None:
                    Q.append(currItem.right)
                    nextCount+=1
            res.append(currRes)
        return res