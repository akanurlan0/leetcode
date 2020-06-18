class Solution {
    
    private int n, m;
    
    public void solve(char[][] board) {
        
        n = board.length;
        if (n == 0) return;
        m = board[n - 1].length;
        
        QuickUnionUF uf = new QuickUnionUF(n * m + 1);
        
        int dummy = node(n, 0);
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'X') continue;
                
                int curr = node(i, j);
                
                if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
                    uf.union(curr, dummy);
                }
                
                if (i - 1 >= 0  && board[i - 1][j] == 'O')   uf.union(curr, node(i - 1, j));
                if (j + 1 < m   && board[i][j + 1] == 'O')   uf.union(curr, node(i, j + 1));
                if (i + 1 < n   && board[i + 1][j] == 'O')   uf.union(curr, node(i + 1, j));
                if (j - 1 >= 0  && board[i][j - 1] == 'O')   uf.union(curr, node(i, j - 1));
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (uf.connected(node(i, j), dummy)) board[i][j] = 'O';
                else                                 board[i][j] = 'X';
            }
        }
        
        // uf.debug();
    }
    
    int node(int i, int j) {
        return i * m + j;
    }
    
    class QuickUnionUF {
        
        private int[] c;
        
        public QuickUnionUF(int capacity) {
            c = new int[capacity];
            for (int i = 0; i < capacity; i++) {
                c[i] = i;
            }
        }
        
        private int root(int i) {
            while (i != c[i]) i = c[i];
            return i;
        }
        
        public void union(int a, int b) {
            int i = root(a);
            int j = root(b);
            c[i] = j;
        }
        
        public boolean connected(int a, int b) {
            return root(a) == root(b);
        }
        
        public void debug() {
            for (int i = 0; i < c.length; i++) System.out.print(c[i] + " ");
            System.out.println();
        }
    }
}