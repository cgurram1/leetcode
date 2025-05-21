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
    if (lists == null || lists.length == 0) return null;
    return mergeRange(lists, 0, lists.length - 1);
}

    private ListNode mergeRange(ListNode[] lists, int lo, int hi) {
        if (lo == hi) return lists[lo];
        int mid = lo + (hi - lo) / 2;
        ListNode left  = mergeRange(lists, lo, mid);
        ListNode right = mergeRange(lists, mid + 1, hi);
        return merge(left, right);      // your O(n+m) merge helper
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