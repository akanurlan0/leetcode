class Solution {
    public int peakIndexInMountainArray(int[] a) {
        
        int n = a.length;
        int l = 0;
        int r = n;
        
        while (true) {
            int peak = (l + r) / 2;
            boolean left = a[peak] > a[peak-1];
            
            if (left == false) {
                r = peak;
                continue;
            }
            
            boolean right = a[peak] > a[peak+1];
            
            if (right == false) {
                l = peak;
                continue;
            }
            
            return peak;
        }
    }
}