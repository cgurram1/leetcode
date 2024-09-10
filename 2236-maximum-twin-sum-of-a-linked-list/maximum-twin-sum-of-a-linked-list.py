# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def pairSum(self, head: Optional[ListNode]) -> int:
        slow = head
        fast = head
        prev = None
        nextNode = None
        res = float('-inf')
        while(fast.next!= None and fast.next.next != None):
            fast = fast.next.next
            nextNode = slow.next
            slow.next = prev
            prev = slow
            slow = nextNode
        nextNode = slow.next
        slow.next = prev
        prev = slow
        slow = nextNode
        while(slow!= None):
            res = max(res,slow.val + prev.val)
            slow = slow.next
            prev = prev.next
        return res
