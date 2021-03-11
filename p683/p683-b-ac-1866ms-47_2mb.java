class Solution {
    public int kEmptySlots(int[] bulbs, int k) {
        
        int n = bulbs.length;
        
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[bulbs[i] - 1] = i + 1;
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k + 1 && i < n; i++) {
            pq.add(a[i]);
        }
        
        Integer global = Integer.MAX_VALUE;
        
        for (int i = 0; i < n - k - 1; i++) {
            int l = a[i];
            int r = a[i + k + 1];
            
            int max = Math.max(l, r);
            pq.remove(l);
            Integer next = pq.peek();
            pq.add(r);
            
            if (next == null || next > max) {
                global = Math.min(global, max);
            }
        }
        
        if (global == Integer.MAX_VALUE) global = -1;
        return global;
    }
}