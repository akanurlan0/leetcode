class Solution {
    public int findNumbers(int[] nums) {
        
        int res = 0;
        
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            
            if (val > 9 && val < 100) res++;
            if (val > 999 && val < 10000) res++;
            if (val > 99999 && val < 1000000) res++;
        }
        
        return res;
    }
}