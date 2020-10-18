class Solution {
    public int maxSubArray(int[] nums) {
        
        int n = nums.length;
        
        int[] sums = new int[n];
        sums[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sums[i] = sums[i-1] + nums[i];
        }
        
        int max = Integer.MIN_VALUE;
        
        for (int i = 0; i < n; i++) {
            int leftSum = 0;
            if (i - 1 >= 0) leftSum = sums[i - 1];
            
            for (int j = i; j < n; j++) {
                if (sums[j] - leftSum > max) {
                    max = sums[j] - leftSum;
                }
            }
        }
        
        return max;
    }
}