# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:
    def amountOfTime(self, root: Optional[TreeNode], start: int) -> int:
        adjList = defaultdict(list)
        def rec(node):
            if(node == None):
                return
            if(node.left!= None):
                adjList[node.val].append(node.left.val)
                adjList[node.left.val].append(node.val)
            if(node.right != None):
                adjList[node.val].append(node.right.val)
                adjList[node.right.val].append(node.val)
            rec(node.left)
            rec(node.right)
        rec(root)
        # print(adjList)

        level = -1
        queue = deque()
        queue.append(start)
        queue.append(None)
        visited = set()
        visited.add(start)

        while(queue[0]!= None):
            level+=1
            while(queue[0] != None):
                currNode = queue.popleft()
                for adjNode in adjList[currNode]:
                    if(adjNode not in visited):
                        queue.append(adjNode)
                        visited.add(adjNode)
            queue.append(queue.popleft())
        return level

            