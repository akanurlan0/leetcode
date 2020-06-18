class Solution {
    
    private int n, m;
    
    public void solve(char[][] board) {
        
        n = board.length;
        if (n == 0) return;
        m = board[n - 1].length;
        
        int[][] c       = new int[n][m];
        boolean[] wrong = new boolean[n*m];      
        wrong[0] = true;
        
        int colorCount = 1;
        
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                
                if (board[i][j] == 'X') continue;
                
                int color1 = 0, color2 = 0;
                if (c[i-1][j] > 0) color1 = c[i-1][j];
                if (c[i][j-1] > 0) color2 = c[i][j-1];
                
                int color = 0;
                if      (color1 > 0 && color2 > 0) { repaint(c, color1, color2, wrong); color = color2; }
                else if (color1 > 0)               color = color1;
                else if (color2 > 0)               color = color2;
                
                if (color == 0) color = colorCount++;
                c[i][j] = color;
                
                if (board[i-1][j] == 'O' && i - 1 == 0)     wrong[color] = true;
                if (board[i][j+1] == 'O' && j + 1 == m - 1) wrong[color] = true;
                if (board[i+1][j] == 'O' && i + 1 == n - 1) wrong[color] = true;
                if (board[i][j-1] == 'O' && j - 1 == 0)     wrong[color] = true;
            }
        }
        
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                if (wrong[c[i][j]] == false) {
                    board[i][j] = 'X';
                }
            }
        }
        
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < m; j++) {
//                 System.out.print(c[i][j] + " ");
//             }
//             System.out.println();
//         }
        
//         for (int i = 0; i < 10; i++) {
//             System.out.println(i + ": " + wrong[i]);
//         }
    }
    
    private void repaint(int[][] c, int from, int to, boolean[] wrong) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m ; j++) {
                if (c[i][j] == from) c[i][j] = to;
            }
        }
        
        wrong[to] = wrong[to] || wrong[from];
    }
}