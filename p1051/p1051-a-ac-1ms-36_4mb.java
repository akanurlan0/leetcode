class Solution {
    public int heightChecker(int[] h) {
        int n = h.length;
        int[] a = new int[n];
        
        for (int i = 0; i < n; i++) {
            a[i] = h[i];
        }
        
        Arrays.sort(a);
        
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] != h[i]) {
                res++;
            }
        }
        
        return res;
    }
}