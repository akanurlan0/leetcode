class Solution {
    public int[] dailyTemperatures(int[] T) {
        
        int n = T.length;
        
        int[] stack = new int[n];
        int ptr = -1;
        int[] result = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (ptr >= 0) {
                int pos = stack[ptr];
                if (T[pos] <= T[i]) {
                    ptr--;
                } else {
                    break;
                }
            }
            if (ptr == -1) {
                result[i] = 0;
            } else {
                result[i] = stack[ptr] - i;
            }
            stack[++ptr] = i;
        }
        
        return result;
    }
}