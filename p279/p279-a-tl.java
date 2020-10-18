class Solution {
    public int numSquares(int n) {
        Queue<Integer> q1 = new LinkedList<Integer>();
        Queue<Integer> q2 = new LinkedList<Integer>();
        
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            nums.add(i * i);
        }
        
        int c = 1;
        Queue<Integer> q = getQueue(c, q1, q2);
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) == n) return c;
            q.add(nums.get(i));
        }
        
        while (true) {
            q = getQueue(c, q1, q2);
            c++;
            Queue<Integer> qNext = getQueue(c, q1, q2);
            
            while (true) {
                Integer curr = q.poll();
                if (curr == null) break;
                
                for (int i = 0; i < nums.size(); i++) {
                    int next = curr + nums.get(i);
                    if (next > n) continue;
                    if (next == n) return c;
                    qNext.add(next);
                }
            }
        }
    }
    
    private Queue<Integer> getQueue(int c, Queue<Integer> q1, Queue<Integer> q2) {
        if ((c & 1) == 0) {
            return q1;
        }
        return q2;
    }
}