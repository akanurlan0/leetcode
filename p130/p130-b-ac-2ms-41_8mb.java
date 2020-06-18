class Solution {
    
    private int n, m;
    
    public void solve(char[][] board) {
        
        n = board.length;
        if (n == 0) return;
        m = board[n - 1].length;
        
        boolean[][] visited      = new boolean[n][m];
        boolean[][] cantSurround = new boolean[n][m];
        Pair[] q                 = new Pair[(n+1)*(m+1)];
        int l = 0, r = 0;
        
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O'  ) { q[r++] = new Pair(i, 0);    visited[i][0] = true;   }
            if (board[i][m-1] == 'O') { q[r++] = new Pair(i, m-1);  visited[i][m-1] = true; }
        }
        
        for (int j = 1; j < m - 1; j++) {
            if (board[0][j] == 'O'  ) { q[r++] = new Pair(0, j);    visited[0][j] = true;   }
            if (board[n-1][j] == 'O') { q[r++] = new Pair(n-1, j);  visited[n-1][j] = true; }
        }
        
        while (l < r) {
            
            Pair cur = q[l];
            int x = cur.x;
            int y = cur.y;
            cantSurround[x][y] = true;
            
            int i, j;
            
            i = x-1; j = y;
            if (i >= 0 && !visited[i][j] && board[i][j] == 'O') {
                visited[i][j] = true;
                q[r++] = new Pair(i, j);
            }
            
            i = x; j = y+1;
            if (j < m && !visited[i][j] && board[i][j] == 'O') {
                visited[i][j] = true;
                q[r++] = new Pair(i, j);
            }
            
            i = x+1; j = y;
            if (i < n && !visited[i][j] && board[i][j] == 'O') {
                visited[i][j] = true;
                q[r++] = new Pair(i, j);
            }
            
            i = x; j = y-1;
            if (j >= 0 && !visited[i][j] && board[i][j] == 'O') {
                visited[i][j] = true;
                q[r++] = new Pair(i, j);
            }
                
            l++;
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (cantSurround[i][j] == false) {
                    board[i][j] = 'X';
                }
            }
        }
    }
    
    class Pair {
        public final int x, y;
        
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}