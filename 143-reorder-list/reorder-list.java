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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
    
        // 1) find mid
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 2) split
        ListNode second = slow.next;
        slow.next = null;

        // 3) reverse second half
        ListNode prev = null, curr = second;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        // now 'prev' is head of reversed second half

        // 4) merge interleaving first half (head) and reversed half (prev)
        ListNode first = head, second2 = prev;
        while (second2 != null) {
            ListNode tmp1 = first.next;
            ListNode tmp2 = second2.next;

            first.next = second2;
            second2.next = tmp1;

            first = tmp1;
            second2 = tmp2;
        }
    }
}