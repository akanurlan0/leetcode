class Solution {
    public int minMoves(int[] nums) {
        
        int n = nums.length;

        int r = 0;
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < n; i++) {
            r += nums[i];
            min = Math.min(min, nums[i]);
        }
        
        r -= n * min;
        
        return r;
    }
}