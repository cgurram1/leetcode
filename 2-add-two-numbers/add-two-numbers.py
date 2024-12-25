# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        res = l1
        carry = 0
        prev = None
        while(l1 and l2):
            add = l1.val + l2.val + carry
            carry = 0
            if add >= 10:
                carry = add // 10
                add = add % 10
                isCarry = True
            else:
                isCarry = False
            l1.val = add
            if l1.next == None:
                prev = l1
            l1 = l1.next
            l2 = l2.next

        while(l1):
            add = l1.val + carry
            carry = 0
            if add >= 10:
                carry = add // 10
                add = add % 10
                isCarry = True
            else:
                isCarry = False
            l1.val = add
            if l1.next == None:
                prev = l1
            l1 = l1.next
        while(l2):
            add = l2.val + carry
            carry = 0
            if add >= 10:
                carry = add // 10
                add = add % 10
                isCarry = True
            else:
                isCarry = False
            prev.next = ListNode(add)
            prev = prev.next
            l2 = l2.next
        if isCarry:
            prev.next = ListNode(carry)
        return res