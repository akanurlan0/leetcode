class Solution {
    public int[] sortArrayByParityII(int[] a) {
        
        int n = a.length;
        int[] res = new int[n];
        
        int pointer = 0;
        for (int i = 0; i < n; i++) {
            if ((a[i] & 1) == 0) {
                res[pointer] = a[i];
                pointer+=2;
            }
        }
        
        pointer = 1;
        for (int i = 0; i < n; i++) {
            if ((a[i] & 1) == 1) {
                res[pointer] = a[i];
                pointer+=2;
            }
        }
        
        return res;
    }
}