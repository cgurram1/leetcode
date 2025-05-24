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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode curr = head;
        while(curr.next != null){
            ListNode newNode = new ListNode(GCD(curr.val,curr.next.val));
            newNode.next = curr.next;
            curr.next = newNode;
            curr = curr.next.next;
        }
        return head;
    }
    public int GCD(int a, int b){
        int right = Math.min(a,b);
        for(int i = right;i>= 2;i--){
            if(a % i == 0 && b % i == 0){
                return i;
            }
        }
        return 1;
    }
}