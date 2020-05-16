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
    public ListNode oddEvenList(ListNode head) {
        ListNode oddStart = null, evenStart = null, oddEnd = null, evenEnd = null;
        
        int i = 1;
        ListNode curr = head;
        while (curr != null) {
            if ((i & 1) == 1) {
                if (oddStart == null) {
                    oddStart = curr;
                }
                if (oddEnd == null) {
                    oddEnd = curr;
                } else {
                    oddEnd.next = curr;
                    oddEnd = oddEnd.next;
                }
            } else {
                if (evenStart == null) {
                    evenStart = curr;
                }
                if (evenEnd == null) {
                    evenEnd = curr;
                } else {
                    evenEnd.next = curr;
                    evenEnd = evenEnd.next;
                }
            }
            curr = curr.next;
            i++;
        }
        if (oddEnd != null) {
            oddEnd.next = evenStart;
        }
        if (evenEnd != null) {
            evenEnd.next = null;
        }
        return oddStart;
    }
}