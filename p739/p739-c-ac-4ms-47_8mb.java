class Solution {
    public int[] dailyTemperatures(int[] T) {
        
        int[] res = new int[T.length];
        
        int[] stack = new int[T.length];
        int p = -1;
        
        for (int i = T.length - 1; i >= 0; i--) {
            
            int curr = T[i];
            
            while (p > -1 && T[stack[p]] <= curr) {
                p--;
            }
            
            if (p == -1) {
                res[i] = 0;
            } else {
                Integer found = stack[p];
                res[i] = found - i;
            }
            
            stack[++p] = i;
        }
        
        return res;
    }
}