class Solution {
    public int[] sortArrayByParity(int[] a) {
        
        int n = a.length;
        int[] result = new int[n];
        int pointer = 0;

        for (int i = 0; i < n; i++) {
            if ((a[i] & 1) == 0) {
                result[pointer++] = a[i];
            }
        }
        
        for (int i = 0; i < n; i++) {
            if ((a[i] & 1) == 1) {
                result[pointer++] = a[i];
            }
        }
        
        return result;
        
    }
}