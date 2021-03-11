class Solution {
    public int numRollsToTarget(int d, int f, int target) {
        
        int[] map = new int[target + 1];
        
        for (int j = 1; j <= Math.min(target, f); j++) map[j] = 1;
        
        int modulo = 1000000007;
        
        for (int i = 1; i < d; i++) {
            for (int j = target; j > 0; j--) {
                if (map[j] == 0) continue;
                for (int k = f; k > 0; k--) {
                    if (j + k > target) continue;
                    map[j+k] = ((map[j+k] % modulo) + (map[j] % modulo)) % modulo;
                }
                map[j] = 0;
            }
        }
        
        return map[target];
    }
}