class Solution {
    public int minMoves(int[] nums) {
        
        int n = nums.length;

        Arrays.sort(nums);
        
        int counter = 0;
        
        for (int i = 1; i < n; i++) {
            counter += nums[i] - nums[0];
        }
        
        return counter;
    }
}