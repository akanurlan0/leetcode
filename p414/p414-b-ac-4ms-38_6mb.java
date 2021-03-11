class Solution {
    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(a, b));
        Set<Integer> present = new HashSet<>();
        
        for (int a : nums) {
            if (present.contains(a)) continue;
            
            pq.add(a);
            present.add(a);
            if (pq.size() > 3) pq.poll();
        }
        
        if (pq.size() == 3) return pq.poll();
        
        int res = 0;
        while (pq.size() > 0) {
            res = pq.poll();
        }
        
        return res;
    }
}