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
        
        ListNode fast = head;
        ListNode slow = head;
        ListNode slowPrev = null;
        
        while (fast != null) {
            fast = fast.next;
            if (n > 0) {
                n--;
            } else {
                slowPrev = slow;
                slow = slow.next;
            }
        }
        
        if (slowPrev == null) {
            head = slow.next;
        } else {
            slowPrev.next = slow.next;
        }
        
        return head;
    }
}