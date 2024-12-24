# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeElements(self, head: Optional[ListNode], val: int) -> Optional[ListNode]:
        def myRec(prevNode,currNode,nextNode,val):
            if nextNode:
                if currNode.val == val:
                    prevNode.next = nextNode
                    myRec(prevNode,nextNode,nextNode.next,val)
                else:
                    myRec(prevNode.next,currNode.next,nextNode.next,val)
            else:
                if currNode.val == val:
                    prevNode.next = nextNode
                    return
        while(head and head.val == val):
            head = head.next
        if head == None:
            return
        res = head
        if head.next:
            myRec(head,head.next,head.next.next,val)
        return res