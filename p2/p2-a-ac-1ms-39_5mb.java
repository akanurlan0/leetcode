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
        ListNode dummy = new ListNode();
        ListNode node = dummy;
        int prev = 0;
        while (l1 != null || l2 != null || prev > 0) {
            int newAdd = prev + (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val);
            prev = newAdd / 10;
            newAdd = newAdd % 10;
            
            node.next = new ListNode(newAdd);
            node = node.next;
            
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        
        return dummy.next;
    }
}