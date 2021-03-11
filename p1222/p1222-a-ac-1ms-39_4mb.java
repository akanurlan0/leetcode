class Solution {
    
    private int[][] map;
    private List<List<Integer>> result;
    
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        
        map = new int[8][8];
        map[king[0]][king[1]] = 2;
        for (int[] queen : queens) {
            map[queen[0]][queen[1]] = 1;
        }
        
        result = new ArrayList<>();
        
        for (int[] queen : queens) {
            
            if (aKingOnTheWay(queen[0], queen[1], -1, 0)
                || aKingOnTheWay(queen[0], queen[1], -1, 1)
                || aKingOnTheWay(queen[0], queen[1], 0, 1)
                || aKingOnTheWay(queen[0], queen[1], 1, 1) 
                || aKingOnTheWay(queen[0], queen[1], 1, 0) 
                || aKingOnTheWay(queen[0], queen[1], 1, -1) 
                || aKingOnTheWay(queen[0], queen[1], 0, -1) 
                || aKingOnTheWay(queen[0], queen[1], -1, -1) 
            ) {
                List<Integer> l = new ArrayList<>();
                l.add(queen[0]);
                l.add(queen[1]);
                result.add(l);
            }
        }
        
        return result;
    }
    
    private boolean aKingOnTheWay(int x, int y, int i, int j) {
        
        boolean flag = false;
        
        while (true) {
            x += i;
            y += j;
            if (x < 0 || x > 7) break;
            if (y < 0 || y > 7) break;
            
            if (map[x][y] == 1) break;
            if (map[x][y] == 2) {
                flag = true;
                break;
            }
        }
        
        return flag;
    }
}