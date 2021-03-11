class Solution {
    
    private List<List<Integer>> result;
    
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        
        boolean[][] map = new boolean[8][8];
        for (int[] queen : queens) {
            map[queen[0]][queen[1]] = true;
        }
        
        result = new ArrayList<>();
        
        int[] dirs = {-1, 0, 1};
        
        for (int x : dirs) {
            for (int y : dirs) {
                for (int k = 0; k < 8; k++) {
                    int i = king[0] + (x * k);
                    int j = king[1] + (y * k);
                    
                    if (i < 0 || i > 7 || j < 0 || j > 7) continue;
                    
                    if (map[i][j]) {
                        result.add(Arrays.asList(i, j));
                        break;
                    }
                }
            }
        }
        
        return result;
    }
}