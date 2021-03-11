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
    public ListNode removeElements(ListNode head, int val) {
        ListNode prev = null;
        ListNode node = head;
        while (node != null) {
            if (node.val == val) {
                if (prev == null) {
                    head = node.next;
                    node = node.next;
                } else {
                    prev.next = node.next;
                    node = node.next;
                }
            } else {
                prev = node;
                node = node.next;
            }
        }
        
        return head;
    }
}