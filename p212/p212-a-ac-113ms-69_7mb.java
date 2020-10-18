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
                dfs(i, j, sb, new ArrayList<>());
            }
        }
        
        return new ArrayList<String>(resultSet);
    }
    
    private void dfs(int row, int col, StringBuilder sb, List<Coord> path) {
        
        // System.out.println("attempt: " + sb + " " + path.size());
        
        String s = sb.toString();
        
        if (trie.startsWith(s) == false) return;
        
        // System.out.println(sb + " " + path);
        
        if (trie.contains(s)) {
            resultSet.add(s);
        }
        
        path.add(new Coord(row, col));
        
        for (int i = 0; i < 4; i++) {
            
            int row1 = row + moves[i][0];
            int col1 = col + moves[i][1];
            
            if (row1 < 0 || row1 >= n) continue;
            if (col1 < 0 || col1 >= m) continue;
            
            if (pathContains(path, row1, col1)) continue;
            
            sb.append(board[row1][col1]);

            dfs(row1, col1, sb, path);
                
            sb.setLength(sb.length() - 1);
        }
        
        path.remove(path.size() - 1);
    }
    
    public boolean pathContains(List<Coord> path, int row, int col) {
        for (int i = path.size() - 1; i >= 0; i--) {
            Coord c = path.get(i);
            if (c.row == row && c.col == col) return true;
        }
        return false;
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
        
        public boolean contains(String s) {
            Trie curr = this;
            
            char[] c = s.toCharArray();
            
            for (int i = 0; i < c.length; i++) {
                int code = code(c[i]);
                if (curr.chars[code] == null) return false;
                curr = curr.chars[code];
            }
            
            return curr.end == true;
        }
        
        public boolean startsWith(String s) {
            Trie curr = this;
            
            char[] c = s.toCharArray();
            
            for (int i = 0; i < c.length; i++) {
                int code = code(c[i]);
                if (curr.chars[code] == null) return false;
                curr = curr.chars[code];
            }
            
            return true;
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