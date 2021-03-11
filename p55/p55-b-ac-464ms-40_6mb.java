class Solution {

    public boolean canJump(int[] nums) {
        int n = nums.length;
        
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        
        q.add(0);
        visited[0] = true;
        
        while (!q.isEmpty()) {
            int index = q.poll();
            int jumps = nums[index];
            
            for (int i = index + 1; i <= index + jumps; i++) {
                if (i >= n) break;
                
                if (visited[i]) continue;
                
                if (i == n - 1) return true;
                
                q.add(i);
                visited[i] = true;
            }
        }
        
        return visited[n - 1];
    }
}