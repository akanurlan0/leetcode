class Solution {
    
    private int[][] map;
    private List<List<Integer>> result;
    private int[][] dirs = new int[][] { {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1} };
    
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        
        map = new int[8][8];
        for (int[] queen : queens) {
            map[queen[0]][queen[1]] = 1;
        }
        
        result = new ArrayList<>();
        
        for (int[] dir : dirs) {
            List<Integer> l = aQueenOnTheWay(king[0], king[1], dir[0], dir[1]);
            if (l != null) {
                result.add(l);
            }
        }
        
        return result;
    }
    
    private List<Integer> aQueenOnTheWay(int x, int y, int i, int j) {
        
        while (true) {
            x += i;
            y += j;
            if (x < 0 || x > 7) break;
            if (y < 0 || y > 7) break;
            
            if (map[x][y] == 1) {
                List<Integer> l = new ArrayList<>();
                l.add(x);
                l.add(y);
                return l;
            }
        }
        
        return null;
    }
}