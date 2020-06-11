class Solution {
    public int searchInsert(int[] nums, int target) {
        
        int n = nums.length;
        
        int l = 0;
        int r = n - 1;
        
        if (n > 0 && nums[0] > target) return 0;
        if (n > 0 && nums[n-1] < target) return n;
        
        while (l < r) {
            int m = l + ( (r - l) / 2 );
            
            if (nums[m] == target) {
                return m;
            }
            
            if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        
        return l;
    }
}