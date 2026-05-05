"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        if head == None:
            return None
        old_to_New = {}
        node = head
        prev = None
        while node != None:
            newNode = Node(node.val,None,None)
            if prev:
                prev.next = newNode
            prev = newNode
            old_to_New[node] = newNode
            node = node.next
        node = head

        while node != None:
            newNode = old_to_New[node]
            if node.random:
                newNode.random = old_to_New[node.random]
            node = node.next
        return old_to_New[head]
        
            