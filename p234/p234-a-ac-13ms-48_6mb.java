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
        
        ListNode prev = null;
        
        StringBuilder forward = new StringBuilder();
        while (head != null) {
            forward.append(head.val);
            forward.append(' ');
            
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        
        StringBuilder backward = new StringBuilder();
        head = prev;
        while (head != null) {
            backward.append(head.val);
            backward.append(' ');
            head = head.next;
        }
        
        return forward.toString().equals(backward.toString());
    }
}