class Solution {
    
    private int[][] steps = new int[][] { {1, 0}, {0, 1}, {-1, 0}, {0, -1} };
    
    public boolean exist(char[][] board, String word) {
        
        char firstChar = word.charAt(0);
        
        boolean[][] used = new boolean[board.length][board[0].length];
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == firstChar) {
                    used[i][j] = true;
                    if (backtracking(board, used, word, 0, i, j)) return true;
                    used[i][j] = false;
                }
            }
        }
        
        return false;
    }
    
    private boolean backtracking(char[][] board, boolean[][] used, String word, int index, int row, int col) {
        
        if (index == word.length() - 1) {
            return true;
        }
        
        for (int i = 0; i < 4; i++) {
            int r = row + steps[i][0];
            int c = col + steps[i][1];
            if (r < 0 || r == board.length || c < 0 || c == board[0].length) continue;
            if (board[r][c] == word.charAt(index + 1) && !used[r][c]) {
                used[r][c] = true;
                boolean res = backtracking(board, used, word, index + 1, r, c);
                used[r][c] = false;
                if (res) return true;
            }
        }
        
        return false;
    }
}