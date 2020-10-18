class Solution {
    
    private int[] nums;
    private int target;
    private int result;
    private Map<Integer, Map<Integer, Integer>> cache;
    
    public int findTargetSumWays(int[] nums, int S) {
        this.nums = nums;
        this.target = S;
        this.result = 0;
        
        cache = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            cache.put(i, new HashMap<Integer, Integer>());
        }
        
        result = dfs(nums.length - 1, target);
        
        return result;
    }
    
    private int dfs(int index, int target) {
        
        if (index < 0) {
            if (target == 0) return 1;
            return 0;
        }
        
        Map<Integer, Integer> cacheRow = cache.get(index);
        if (cacheRow.containsKey(target)) return cacheRow.get(target);
                
        int result = 0;
        result += dfs(index - 1, target - nums[index]);
        result += dfs(index - 1, target + nums[index]);
        
        cacheRow.put(target, result);
        
        return result;
    }
}