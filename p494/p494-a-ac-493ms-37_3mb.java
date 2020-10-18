class Solution {
    
    private int[] nums;
    private int target;
    private int result;
    
    public int findTargetSumWays(int[] nums, int S) {
        this.nums = nums;
        this.target = S;
        this.result = 0;
        
        dfs(0, 0);
        
        return result;
    }
    
    private void dfs(int index, int prevSum) {
        if (index == nums.length) {
            if (prevSum == target) {
                result++;
            }
            return;
        }
        
        dfs(index + 1, prevSum - nums[index]);
        dfs(index + 1, prevSum + nums[index]);
    }
}