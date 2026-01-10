# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxLevelSum(self, root: Optional[TreeNode]) -> int:
        maxValue = float('-inf')
        level = -1

        q = deque()
        q.append(root)
        q.append(None)
        l = 0

        while(q[0] != None):
            s = 0
            l+=1
            while(q[0]!=None):
                currNode = q.popleft()
                s+=currNode.val
                if(currNode.left):
                    q.append(currNode.left)
                if(currNode.right):
                    q.append(currNode.right)
            if s > maxValue:
                maxValue = s
                level = l
            q.append(q.popleft())
            
        return level