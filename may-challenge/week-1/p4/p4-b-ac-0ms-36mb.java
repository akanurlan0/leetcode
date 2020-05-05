class Solution {
    public int findComplement(int num) {
        int tp = Integer.MAX_VALUE;
        while (true) {
            int nv = tp >> 1;
            if (nv < num) break;
            tp = nv;
        }
        
        return tp ^ num;
    }
}