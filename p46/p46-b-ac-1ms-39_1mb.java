class Solution {
    
    public List<List<Integer>> permute(int[] nums) {
    
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        
        backtracking(result, new ArrayList<Integer>(), used, nums);
        
        return result;
    }
    
    private void backtracking(
        List<List<Integer>> result,
        List<Integer> list,
        boolean[] used,
        int[] nums
    ) {
        if (list.size() == nums.length) {
            result.add(new ArrayList(list));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            
            if (used[i]) continue;
            
            used[i] = true;
            list.add(nums[i]);
            backtracking(result, list, used, nums);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }
}