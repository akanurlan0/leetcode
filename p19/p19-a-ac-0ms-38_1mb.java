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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode tail = reverse(head);
        ListNode node = tail;
        
        ListNode prev = null;
        while (--n > 0) {
            prev = node;
            node = node.next;
        }
        
        if (prev == null) {
            prev = node.next;
            tail = prev;
        } else {
            prev.next = node.next;
        }
        
        return reverse(tail);
    }
    
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}