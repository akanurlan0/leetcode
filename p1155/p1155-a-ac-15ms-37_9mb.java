class Solution {
    public int numRollsToTarget(int d, int f, int target) {
        
        int[][] map = new int[d + 1][target + 1];
        
        for (int j = 1; j <= Math.min(target, f); j++) map[1][j] = 1;
        
        int modulo = 1000000007;
        
        for (int i = 1; i < d; i++) {
            for (int j = 1; j <= target; j++) {
                if (map[i][j] == 0) continue;
                for (int k = 1; k <= f; k++) {
                    if (j + k > target) continue;
                    map[i+1][j+k] = ((map[i+1][j+k] % modulo) + (map[i][j] % modulo)) % modulo;
                }
            }
        }
        
        return map[d][target];
    }
}