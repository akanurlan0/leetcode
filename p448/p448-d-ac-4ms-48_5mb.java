class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            
            int k = nums[i];
            if (k < 0) {
                k = -k;
            }
            
            int v = nums[k - 1];
            if (v > 0) {
                nums[k - 1] = -nums[k - 1];
            }
        }
        
        List<Integer> res = new ArrayList<Integer>();
        
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }
        
        return res;
    }
}