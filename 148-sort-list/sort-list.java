/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = getMid(head);
        ListNode rightHead = mid.next;
        mid.next = null;
        ListNode leftSorted = sortList(head);
        ListNode rightSorted = sortList(rightHead);
        return merge(leftSorted, rightSorted);
    }
    private ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode merge(ListNode head1, ListNode head2){
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while(head1 != null && head2 != null){
            if(head1.val < head2.val){
                head.next = head1;
                head1 = head1.next;
            }
            else{
                head.next = head2;
                head2 = head2.next;
            }
            head = head.next;
        }
        head.next = (head1 != null) ? head1 : head2;
        return dummy.next;
    }
}