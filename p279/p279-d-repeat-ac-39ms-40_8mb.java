class Solution {
    public int numSquares(int n) {
        
        Queue<Integer> queue = new LinkedList<Integer>();
        Set<Integer> visited = new HashSet<Integer>();
        
        int step = 0;
        queue.add(0);
        
        while (queue.peek() != null) {
            
            step++;
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                
                for (int j = 1; j <= n; j++) {
                    int k = curr + (j * j);
                    if (k > n) break;
                    
                    if (k == n) return step;
                    
                    if (visited.contains(k)) continue;
                    
                    queue.add(k);
                    visited.add(k);
                }
            }
        }

        throw new IllegalStateException();
    }
}