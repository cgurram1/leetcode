"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""

class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if root == None:
            return root
        queue = deque()
        queue.append((root,None))
        while queue:
            direct = True
            for _ in range(len(queue)):
                node,parent = queue.popleft()
                if node.left:
                    queue.append((node.left,node))
                    queue.append((node.right,node))
                if parent == None:
                    node.next = None
                else:
                    if direct == True:
                        node.next = parent.right
                        direct = False
                    else:
                        if parent.next:
                            node.next = parent.next.left
                        else:
                            node.next = None
                        direct = True
        return root
