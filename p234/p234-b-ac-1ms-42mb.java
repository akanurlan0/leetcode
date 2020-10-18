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
    public boolean isPalindrome(ListNode head) {
        
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        if (fast != null) {
            slow = slow.next; // skipping the middle
        }
        
        ListNode tail = reverse(slow);
        ListNode tail2 = tail;
        
        boolean result = true;
        
        while (tail != null) {
            if (tail.val != head.val) {
                result = false;
                break;
            }
            tail = tail.next;
            head = head.next;
        }
        
        reverse(tail2);

        return result;
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