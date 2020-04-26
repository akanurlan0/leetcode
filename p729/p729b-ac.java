class Solution {
    public int[] dailyTemperatures(int[] T) {
        
        int n = T.length;

        int[] map = new int[101];
        for (int i = 0; i < 101; i++) map[i] = n;
        
        int[] result = new int[n];
        
        for (int i = n - 1; i >= 0; i--) {
            
            int value = T[i];
            
            int minPos = n;
            
            for (int j = value + 1; j < 101; j++) {
                if (map[j] != n) {
                    minPos = map[j] < minPos ? map[j] : minPos;
                }
            }
            
            result[i] = minPos == n ? 0 : minPos - i;
            
            map[value] = i;
        }
        
        return result;
    }
}