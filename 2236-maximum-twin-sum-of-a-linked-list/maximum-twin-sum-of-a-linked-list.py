# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def pairSum(self, head: Optional[ListNode]) -> int:
        tempArr = []
        pointer = head
        while(pointer != None):
            tempArr.append(pointer.val)
            pointer = pointer.next
        res = float('-inf')
        for i in range(len(tempArr)):
            res = max(res,tempArr[i] + tempArr[len(tempArr) - i - 1])
        return res
