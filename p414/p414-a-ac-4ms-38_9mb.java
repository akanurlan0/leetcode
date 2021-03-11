class Solution {
    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(b, a));
        Set<Integer> present = new HashSet<>();
        
        for (int a : nums) {
            if (present.contains(a)) continue;
            
            pq.add(a);
            present.add(a);
        }
        
        int i = 0;
        int res = 0;
        
        while (!pq.isEmpty()) {
            i++;
            int a = pq.poll();
            if (i == 1) {
                res = a;
            }
            if (i == 3) {
                res = a;
                break;
            }
        }
        
        return res;
    }
}