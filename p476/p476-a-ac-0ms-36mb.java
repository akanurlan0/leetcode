class Solution {
    public int findComplement(int num) {
        int[] stack = new int[32];
        int s = 0;
        
        while (num > 0) {
            int lastByte = num & 1;
            stack[s++] = lastByte;
            num = num >> 1;
        }
        
        if (s == 0) s++;
        
        int res = 0;
        
        while (s > 0) {
            res = res << 1;
            res = res | (1 - stack[s-1]);
            s--;
        }
        
        return res;
    }
}