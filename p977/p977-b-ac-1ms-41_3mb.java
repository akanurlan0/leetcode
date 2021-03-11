class Solution {
    public int[] sortedSquares(int[] a) {
        int n = a.length;
        
        int[] res = new int[n];
        
        int l = 0;
        int r = n - 1;
        
        for (int i = n - 1; i >= 0; i--) {
            int val;
            if (Math.abs(a[l]) > Math.abs(a[r])) {
                val = a[l];
                l++;
            } else {
                val = a[r];
                r--;
            }
            
            res[i] = val * val;
        }
        
        return res;
    }
}