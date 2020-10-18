class Solution {
    
    private int[][] dirs = { {1, 0}, {0, 1}, {-1, 0}, {0, -1} };
    
    public int numIslands(char[][] grid) {
        Queue<Integer> queue = new LinkedList<Integer>();
        
        int n = grid.length;
        if (n == 0) return 0;
        int m = grid[n - 1].length;

        int result = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    queue.add((i * m) + j);
                    result++;
                }
                
                while (queue.peek() != null) {
                    int index = queue.poll();
                    int row = index / m;
                    int col = index % m;
                    
                    grid[i][j] = '2';
                    
                    for (int k = 0; k < 4; k++) {
                        int nextRow = row + dirs[k][0];
                        int nextCol = col + dirs[k][1];
                        
                        if (nextRow < 0 || nextRow == n || nextCol < 0 || nextCol == m) continue;
                        
                        if (grid[nextRow][nextCol] == '1') {
                            queue.add((nextRow * m) + nextCol);
                            grid[nextRow][nextCol] = '2';
                        }
                    }
                }
            }
        }
        
        return result;
    }
}