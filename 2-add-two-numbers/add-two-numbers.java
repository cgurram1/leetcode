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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode top = l1;
        ListNode bottom = l2;
        int carry = 0;
        ListNode head = new ListNode(0,null);
        ListNode temp = head;
        while(top!= null && bottom != null){
            ListNode newNode = new ListNode((top.val + bottom.val + carry) %10, null);
            head.next = newNode;
            head = head.next;
            carry = (top.val + bottom.val + carry)/10;
            top = top.next;
            bottom = bottom.next;
        }
        while(top!= null){
            ListNode newNode = new ListNode((top.val + carry)%10, null);
            head.next = newNode;
            head = head.next;
            carry = (top.val + carry)/10;
            top = top.next;
        }
        while(bottom!= null){
            ListNode newNode = new ListNode((bottom.val + carry)%10, null);
            head.next = newNode;
            head = head.next;
            carry = (bottom.val + carry)/10;
            bottom = bottom.next;
        }
        if(carry > 0){
            ListNode newNode = new ListNode(carry, null);
            head.next = newNode;
        }
        return temp.next;
    }
}