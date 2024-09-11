# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def detectCycle(self, head: Optional[ListNode]) -> Optional[ListNode]:
        slow = head
        fast = head
        slow2 = head
        while True:
            if fast == None or fast.next == None:
                break
            slow = slow.next
            fast = fast.next.next
            if slow == fast:
                break
        if fast == None or fast.next == None:
            return None
        while(slow != slow2):
            slow = slow.next
            slow2 = slow2.next
        return slow