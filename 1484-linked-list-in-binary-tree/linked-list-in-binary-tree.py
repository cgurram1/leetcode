# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSubPath(self, head: Optional[ListNode], root: Optional[TreeNode]) -> bool:
        arr = []
        while(head != None):
            arr.append(head.val)
            head = head.next
        def fun(node):
            if(node != None):
                if rec(node, 0):
                    return True
                if fun(node.left):
                    return True
                if fun(node.right):
                    return True
            return False
            
        def rec(node, pointer):
            if(pointer == len(arr)):
                return True
            if(node == None):
                return False
            if(node.val == arr[pointer]):
                return rec(node.left, pointer + 1) or rec(node.right, pointer + 1)
            return False
        
        return fun(root)