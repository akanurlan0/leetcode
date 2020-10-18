class Solution {
    
    private int[] nums;
    
    public List<List<Integer>> subsets(int[] nums) {
        
        this.nums = nums;
        boolean[] map = new boolean[nums.length];
        List<List<Integer>> result = new ArrayList<>();
        traverse(0, map, result);
        return result;
    }
    
    private void traverse(int i, boolean[] map, List<List<Integer>> result) {
        
        if (i == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if (map[j]) list.add(nums[j]);
            }
            result.add(list);
            return;
        }
        
        map[i] = false;
        traverse(i + 1, map, result);
        map[i] = true;
        traverse(i + 1, map, result);
    }
}