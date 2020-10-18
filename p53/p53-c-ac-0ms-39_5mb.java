class Solution {
    public int maxSubArray(int[] nums) {
        
        int n = nums.length;
        
        int max = nums[0];
        int localMax = nums[0];
        
        for (int i = 1; i < n; i++) {
            localMax = Math.max(nums[i], localMax + nums[i]);
            max = Math.max(localMax, max);
        }
        
        return max;
    }
}