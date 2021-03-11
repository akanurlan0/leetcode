class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int i = 0;
        int j = 0;
        int n = popped.length;
        boolean result = true;
        
        for (int k = 0; k < n; k++) {
            if (pushed[k] == 0) pushed[k] = 1000;
            if (popped[k] == 0) popped[k] = 1000;
        }
            
        while (i < n && j < n) {
            if (i < 0) {
                do {
                    i++;
                } while (i < n && pushed[i] < 0);
                continue;
            }
            if (pushed[i] == popped[j]) {
                j++;
                pushed[i] = -pushed[i];
                while (i >= 0 && pushed[i] < 0) {
                    i--;
                }
                continue;
            }
            if (pushed[i] != popped[j]) {
                do {
                    i++;
                } while (i < n && pushed[i] < 0);
                continue;
            }
        }
        if (j < n) {
            result = false;
        }
        
        return result;
    }
}