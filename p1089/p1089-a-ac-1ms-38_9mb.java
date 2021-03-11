class Solution {
    public void duplicateZeros(int[] arr) {
        
        int zeros = 0;
        for (int n : arr) {
            if (n == 0) zeros++;
        }
        
        for (int i = arr.length - 1; i >= 0; i--) {
            int n = arr[i];
            if (n == 0) zeros--;
            
            int pos = i + zeros;
            
            if (pos >= arr.length) continue;
            arr[pos] = n;
            
            if (n == 0) {
                if (pos + 1 >= arr.length) continue;
                arr[pos + 1] = n;
            }
        }
        
    }
}