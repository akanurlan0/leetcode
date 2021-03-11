class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        
        int zeroAdd = 0;
        int l = 0;
        int r = 0;
        int res = 0;
        
        for (int val : nums) {
            if (val == 1) {
                r++;
            } else {
                res = Math.max(res, l + r + zeroAdd);
                l = r;
                r = 0;
                zeroAdd = 1;
            }
        }
        
        res = Math.max(res, l + r + zeroAdd);
        
        return res;
    }
}