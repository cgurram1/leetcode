# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        curr = ListNode(0)
        res = curr
        def myFun(root1,root2,curr):
            if root1 and root2:
                if root1.val < root2.val:
                    curr.next = root1
                    curr = curr.next
                    myFun(root1.next,root2,curr)
                else:
                    curr.next = root2
                    curr = curr.next
                    myFun(root1,root2.next,curr)
            else:
                if root1:
                    curr.next = root1
                else:
                    curr.next = root2
        myFun(list1,list2,curr)
        return res.next

            
