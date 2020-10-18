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
        
        Queue<ListNode> pq = new PriorityQueue<ListNode>((o1, o2) -> o1.val - o2.val);
        
        for (int i = 0; i < k; i++) {
            if (lists[i] != null) {
                pq.add(lists[i]);
            }
        }
        
        while (!pq.isEmpty()) {

            ListNode min = pq.poll();
            
            if (curr == null) {
                curr = min;
            } else {
                curr.next = min;
                curr = curr.next;
            }
            
            if (head == null) {
                head = curr;
            }
            
            if (min.next != null) {
                pq.add(min.next);
            }
        }
        
        return head;
    }
}