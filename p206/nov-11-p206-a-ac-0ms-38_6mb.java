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
    public ListNode reverseList(ListNode head) {
        
        if (head == null) return null;
        
        ListNode curr = head;
        while (curr.next != null) {
            ListNode newHead = curr.next;
            curr.next = newHead.next;
            newHead.next = head;
            head = newHead;
        }
        
        return head;
    }
}