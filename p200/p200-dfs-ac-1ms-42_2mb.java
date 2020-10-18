class Solution {
    
    private int[][] dirs = { {1, 0}, {0, 1}, {-1, 0}, {0, -1} };
    
    private char[][] grid;
    private int n, m;
    
    public int numIslands(char[][] g) {

        grid = g;
        n = grid.length;
        if (n == 0) return 0;
        m = grid[n - 1].length;

        int result = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j);
                    result++;
                }
            }
        }
        
        return result;
    }
    
    private void dfs(int row, int col) {
        grid[row][col] = '2';
        for (int k = 0; k < 4; k++) {
            int nextRow = row + dirs[k][0];
            int nextCol = col + dirs[k][1];

            if (nextRow < 0 || nextRow == n || nextCol < 0 || nextCol == m) continue;

            if (grid[nextRow][nextCol] == '1') {
                dfs(nextRow, nextCol);
            }
        }
    }
}