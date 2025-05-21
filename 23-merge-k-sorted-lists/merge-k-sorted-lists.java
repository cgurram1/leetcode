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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) 
            return null;
        ListNode head1 = lists[0];
        for(int i = 1;i<lists.length;i++){
            ListNode head2 = lists[i];
            head1 = merge(head1,head2);
        }
        return head1;
    }
    public ListNode merge(ListNode head1, ListNode head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;
        ListNode returnNode = null;
        ListNode curr = null;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                if (returnNode == null) {
                    returnNode = head1;
                    curr = head1;
                } else {
                    curr.next = head1;
                    curr = head1;
                }
                head1 = head1.next;
            } else {
                if (returnNode == null) {
                    returnNode = head2;
                    curr = head2;
                } else {
                    curr.next = head2;
                    curr = head2;
                }
                head2 = head2.next;
            }
        }
        curr.next = (head1 != null) ? head1 : head2;
        return returnNode;
    }
}