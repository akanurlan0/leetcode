class Solution {
    public int[] sortArrayByParity(int[] a) {
        
        int n = a.length;
        
        int left = 0;
        int right = n - 1;
        
        while (left < right) {
            
            if ((a[left] & 1) == 0) {
                left++;
                continue;
            }
            
            if ((a[right] & 1) == 1) {
                right--;
                continue;
            }
            
            int tmp = a[left];
            a[left] = a[right];
            a[right] = tmp;
        }
        
        return a;
    }
}