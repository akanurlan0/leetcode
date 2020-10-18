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
        
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        
        Queue<ListNode> pq = new PriorityQueue<ListNode>((o1, o2) -> Integer.compare(o1.val, o2.val));
        
        for (int i = 0; i < k; i++) {
            if (lists[i] != null) {
                pq.add(lists[i]);
            }
        }
        
        while (!pq.isEmpty()) {

            tail.next = pq.poll();
            tail = tail.next;
            
            if (tail.next != null) {
                pq.add(tail.next);
            }
        }
        
        return dummy.next;
    }
}