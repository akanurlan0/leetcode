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
    public ListNode mergeKLists(ListNode[] lists) {
        
        int k = lists.length;
        
        ListNode head = null;
        ListNode curr = null;
        
        while (true) {
            
            ListNode min = null;
            int index = -1;
            
            for (int i = 0; i < k; i++) {
                if (lists[i] == null) continue;
                if (min == null || min.val > lists[i].val) {
                    min = lists[i];
                    index = i;
                }
            }
            
            if (min == null) break;
            
            if (curr == null) {
                curr = min;
            } else {
                curr.next = min;
                curr = curr.next;
            }
            
            if (head == null) {
                head = curr;
            }
            
            lists[index] = lists[index].next;
        }
        
        return head;
    }
}