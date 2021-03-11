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
    public ListNode swapPairs(ListNode head) {
        
        if (head == null) return null;
        if (head.next == null) return head;
        
        ListNode a = head;
        ListNode b = head.next;
        ListNode c = head.next.next;
        
        b.next = a;
        a.next = swapPairs(c);
        
        return b;
    }
}