class Solution {
    public int[] countBits(int num) {
        
        int[] c = new int[num+1];
        
        for (int i = 0; i <= num; i++) {
            c[i] = (c[ i >> 1 ]) + (i & 1);
        }
        
        return c;
    }
}