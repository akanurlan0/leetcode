class Solution {
    public int oddEvenJumps(int[] a) {
        
        int n = a.length;
        
        int[] o = new int[n];
        int[] e = new int[n];
        
        for (int i = 0; i < n; i++) o[i] = 1;
        
        for (int i = 0; i < n; i++) {
            
            {
                int min = Integer.MAX_VALUE;
                int ind = -1;

                for (int j = i + 1; j < n; j++) {
                    if (a[j] < a[i]) continue;
                    if (a[j] < min) {
                        min = a[j];
                        ind = j;
                    }
                }

                if (min != Integer.MAX_VALUE) {
                    e[ind] += o[i];
                }
            }
            
            if (e[i] > 0) {
                
                int max = Integer.MIN_VALUE;
                int ind = -1;
                
                for (int j = i + 1; j < n; j++) {
                    if (a[j] > a[i]) continue;
                    if (a[j] > max) {
                        max = a[j];
                        ind = j;
                    }
                }
                
                if (max != Integer.MIN_VALUE) {
                    o[ind] += e[i];
                }
            }
        }
        
        return o[n - 1] + e[n - 1];
    }
}