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
        
        ListNode nodeA = headA;
        
        while (nodeA != null) {
            nodeA.val = -nodeA.val;
            nodeA = nodeA.next;
        }
        
        ListNode intersection = null;
        
        ListNode nodeB = headB;
        while (nodeB != null) {
            if (nodeB.val < 0) {
                intersection = nodeB;
                break;
            }
            nodeB = nodeB.next;
        }
        
        nodeA = headA;
        while (nodeA != null) {
            nodeA.val = -nodeA.val;
            nodeA = nodeA.next;
        }
        
        return intersection;
    }
}