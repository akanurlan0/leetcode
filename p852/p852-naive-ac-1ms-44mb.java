class Solution {
    public int peakIndexInMountainArray(int[] a) {
        
        int peak = 0;
        
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i+1] && a[i] > a[i-1]) {
                peak = i;
                break;
            }
        }
        
        return peak;
    }
}