class Solution {
    public int[] sortArrayByParityII(int[] a) {
        
        int n = a.length;
        
        int i = 0;
        int j = 1;
        
        while (i < n) {
            
            if ((a[i] & 1) == 0) {
                i+=2;
                continue;
            }
                
            while (j < n) {
                if ((a[j] & 1) == 1) {
                    j+=2;
                } else {
                    break;
                }
            }

            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
        
        return a;
    }
}