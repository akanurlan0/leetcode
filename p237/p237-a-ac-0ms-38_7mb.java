/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode prev = null;
        while (node != null) {
            ListNode next = node.next;
            if (next == null) {
                prev.next = null;
            } else {
                node.val = next.val;
            }
            prev = node;
            node = next;
        }
    }
}