class Solution {
    
    private boolean[][] visited;
    private int[][] dirs = { {1, 0}, {0, 1}, {-1, 0}, {0, -1} };
    
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[n-1].length;
        visited = new boolean[n][m];
        
        int remaining = 0;
        
        Queue<Pair> q = new LinkedList<Pair>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Pair(i,j));
                    visited[i][j] = true;
                } 
                else if (grid[i][j] == 1) {
                    remaining++;
                }
            }
        }

        int minute = 0;
        
        while (true) {
            int size = q.size();
            
            while (size-- > 0) {
                Pair curr = q.poll();
                
                for (int i = 0; i < 4; i++) {
                    int xx = curr.x + dirs[i][0];
                    int yy = curr.y + dirs[i][1];
                    if (0 > xx || xx >= n || 0 > yy || yy >= m) continue;
                    if (grid[xx][yy] == 1 && visited[xx][yy] == false) {
                        q.add(new Pair(xx, yy));
                        visited[xx][yy] = true;
                        remaining--;
                    }
                }
            }
            
            if (q.peek() == null) break;
            minute++;
        }
        
        if (remaining > 0) return -1;
        return minute;
    }
    
    class Pair {
        int x, y;
        
        public Pair(int xx, int yy) {
            x = xx;
            y = yy;
        }
    }
}