# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        slow = head
        fast = head
        prev = None
        nextNode = None
        while fast and fast.next:
            fast = fast.next.next
            nextNode = slow.next
            slow.next = prev
            prev = slow
            slow = nextNode
        if fast == None:
            pass
        elif nextNode and fast.next == None:
            nextNode = nextNode.next
        while(nextNode and nextNode.val == prev.val):
            nextNode = nextNode.next
            prev = prev.next
        if nextNode:
            return False
        return True
        
