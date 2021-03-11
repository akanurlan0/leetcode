class Solution {
    public int[] sortArrayByParity(int[] a) {
        
        int l = 0;
        int r = a.length - 1;
        
        while (l < r) {
            if (a[l] % 2 == 0) {
                l++;
                continue;
            }
            
            while (r > l && a[r] % 2 == 1) {
                r--;
                continue;
            }
            
            int t = a[l];
            a[l] = a[r];
            a[r] = t;
            l++;
            r--;
        }
        
        return a;
    }
}