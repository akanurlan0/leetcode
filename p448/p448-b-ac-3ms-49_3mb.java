class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        
        boolean[] map = new boolean[n + 1];
        
        for (int i = 0; i < n; i++) {
            map[nums[i]] = true;
        }
        
        List<Integer> res = new ArrayList<Integer>();
        
        for (int i = 1; i <= n; i++) {
            if (map[i] == false) {
                res.add(i);
            }
        }
        
        return res;
    }
}