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
        def fun(node,isLeft,parent):
            if node:
                if parent:
                    if isLeft:
                        node.next = parent.right
                    else:
                        if parent.next:
                            node.next = parent.next.left
                fun(node.left,True,node)
                fun(node.right,False,node)
        fun(root,True,None)
        return root
