/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tailA = reverse(headA);
        ListNode tailB = reverse(headB);
        
        ListNode nodeA = tailA;
        ListNode nodeB = tailB;
        
        ListNode intersection = null;
        
        while (nodeA != null && nodeB != null && nodeA.val == nodeB.val) {
            intersection = nodeA;
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        
        reverse(tailA);
        reverse(tailB);
        
        return intersection;
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