class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        
        List<Integer> res = new ArrayList<Integer>();
        
        for (int i = 1; i <= n; i++) {
            
            boolean flag = true;
            
            for (int j = 0; j < n; j++) {
                if (nums[j] == i) {
                    flag = false;
                    break;
                }
            }
            
            if (flag) {
                res.add(i);
            }
        }
        
        return res;
    }
}