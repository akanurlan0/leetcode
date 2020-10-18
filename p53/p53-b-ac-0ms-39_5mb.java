class Solution {
    public int maxSubArray(int[] nums) {
        
        int n = nums.length;
        
        int m = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            m = Math.max(m, nums[i]);
        }
        if (m > 0) m = 0;
        
        int max = m;
        int localMax = 0;
        
        for (int i = 0; i < n; i++) {
            localMax = Math.max(m, localMax + nums[i]);
            max = Math.max(localMax, max);
        }
        
        return max;
    }
}