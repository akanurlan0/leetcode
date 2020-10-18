class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<Set<Integer>> rows = new ArrayList<>();
        for (int i = 0; i < 9; i++) rows.add(new HashSet<Integer>());
        List<Set<Integer>> cols = new ArrayList<>();
        for (int i = 0; i < 9; i++) cols.add(new HashSet<Integer>());
        List<Set<Integer>> boxes = new ArrayList<>();
        for (int i = 0; i < 9; i++) boxes.add(new HashSet<Integer>());
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') continue;
                int val = board[i][j] - '0';
                
                Set<Integer> row = rows.get(i);
                if (row.contains(val)) return false;
                row.add(val);
                
                Set<Integer> col = cols.get(j);
                if (col.contains(val)) return false;
                col.add(val);
                
                Set<Integer> box = boxes.get(getBoxIndex(i,j));
                if (box.contains(val)) return false;
                box.add(val);
            }
        }
        
        return true;
    }
    
    private int getBoxIndex(int i, int j) {
        int res = 0;        
    
        if      (i < 3) res += 0;
        else if (i < 6) res += 3;
        else            res += 6;
        
        if      (j < 3) res += 1;
        else if (j < 6) res += 2;
        else            res += 3;
        
        return res - 1;
    }
}