class Solution {
    public int numSquares(int n) {
        Queue<Integer> q = new LinkedList<Integer>();

        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            nums.add(i * i);
        }
        
        int depth = 0;
        q.add(0);

        Set<Integer> visited = new HashSet<Integer>();
        
        while (true) {
            depth++;
            
            int size = q.size();
            
            while (size-- > 0) {
                Integer curr = q.poll();
                
                for (int i = 0; i < nums.size(); i++) {
                    int next = curr + nums.get(i);
                    if (next > n) continue;
                    if (next == n) return depth;
                    if (visited.contains(next)) continue;
                    q.add(next);
                    visited.add(next);
                }
            }
        }
    }
}