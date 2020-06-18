class Solution {
    
    private int[][] dirs = new int[][] { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
    private char[][] b;
    private int n, m;
    
    public void solve(char[][] board) {
        
        this.b = board;
        this.n = board.length;
        if (this.n == 0) return;
        this.m = board[n - 1].length;
        
        for (int i = 0; i < n; i++) {
            if (b[i][0] == 'O')     dfs(i, 0);
            if (b[i][m - 1] == 'O') dfs(i, m - 1);
        }
        
        for (int j = 0; j < m; j++) {
            if (b[0][j] == 'O')     dfs(0, j);
            if (b[n - 1][j] == 'O') dfs(n - 1, j);
        }
        
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if  (b[i][j] == 'O')        b[i][j] = 'X';
                else if (b[i][j] == '1')    b[i][j] = 'O';
    }
    
    private void dfs(int x, int y) {
        
        b[x][y] = '1';
        
        for (int[] dir : dirs) {
            int i = x + dir[0];
            int j = y + dir[1];
            
            if (i < 0 || i == n || j < 0 || j ==m || b[i][j] != 'O') continue;
            
            dfs(i, j);
        }
    }
    
}