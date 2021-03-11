class Solution {
    public int[] sortedSquares(int[] a) {
        int n = a.length;
        
        int m = 0;
        
        while (m < n && a[m] < 0) {
            a[m++] *= -1;
        }
        
        int l = m - 1;
        int r = m;
        
        int[] res = new int[n];
        int i = 0;
        while (l >= 0 || r < n) {
            int val;
            if (l >= 0 && r < n) {
                if (a[l] < a[r]) {
                    val = a[l--];
                } else {
                    val = a[r++];
                }
            } else
            if (l >= 0) {
                val = a[l--];
            } else {
                val = a[r++];
            }
            res[i++] = val * val;
        }
        
        return res;
    }
}