class Solution {
    
    private char[][] board;
    private int n, m;
    private Trie trie;
    private int[][] moves = new int[][] { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
    private Set<String> resultSet;
    
    public List<String> findWords(char[][] board, String[] words) {
        trie = new Trie();
        
        for (int i = 0; i < words.length; i++) {
            trie.add(words[i]);
        }
        
        n = board.length;
        m = board[n - 1].length;
        
        this.board = board;
        this.resultSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                StringBuilder sb = new StringBuilder();
                sb.append(board[i][j]);
                dfs(i, j, sb);
            }
        }
        
        return new ArrayList<String>(resultSet);
    }
    
    private void dfs(int row, int col, StringBuilder sb) {

        String s = sb.toString();
        
        int contains = trie.contains(sb);
        
        if (contains == -1) return;
        
        if (contains == 1) {
            resultSet.add(s);
        }
        
        char temp = board[row][col];
        board[row][col] = '0';
        
        for (int i = 0; i < 4; i++) {
            
            int row1 = row + moves[i][0];
            int col1 = col + moves[i][1];
            
            if (row1 < 0 || row1 >= n) continue;
            if (col1 < 0 || col1 >= m) continue;
            
            if (board[row1][col1] == '0') continue;
            
            sb.append(board[row1][col1]);

            dfs(row1, col1, sb);
                
            sb.setLength(sb.length() - 1);
        }
        
        board[row][col] = temp;
    }

    class Trie {
        private Trie[] chars;
        private boolean end;
        
        Trie() {
            chars = new Trie[26];
            end = false;
        }
        
        public void setEnd(boolean end) {
            this.end = end;
        }
        
        public void add(String s) {
            Trie curr = this;
            
            char[] c = s.toCharArray();
            
            for (int i = 0; i < c.length; i++) {
                int code = code(c[i]);
                if (curr.chars[code] == null) {
                    curr.chars[code] = new Trie();
                }
                curr = curr.chars[code];
            }
            curr.setEnd(true);
        }
        
        public int contains(StringBuilder sb) {
            Trie curr = this;
            
            for (int i = 0; i < sb.length(); i++) {
                int code = code(sb.charAt(i));
                if (curr.chars[code] == null) return -1;
                curr = curr.chars[code];
            }
            
            if (curr.end == true) return 1;
            return 0;
        }
        
        private int code(char c) {
            return c - 97;
        }
    }

    class Coord {
        int row;
        int col;
        
        public Coord(int row, int col) {
            this.row = row;
            this.col = col;
        }
        
        public String toString() {
            return "(" + row + ", " + col + ")";
        }
    }
}