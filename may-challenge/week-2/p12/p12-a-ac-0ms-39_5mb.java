class Solution {
    public int singleNonDuplicate(int[] nums) {
        
        int l = 0;
        int r = nums.length - 1;
        
        while (l < r) {
            
            int m = l + ((r - l)/2);
            if (m % 2 == 0) {
                
                // case: last element
                
                if (nums[m] == nums[m+1]) {
                    l = m + 2;
                    continue;
                } else {
                    r = m;
                }
            } else {
                
                // case: first element
                
                if (nums[m] == nums[m-1]) {
                    l = m + 1;
                    continue;
                } else {
                    r = m - 1;
                }
            }
            
        }
        
        return nums[l];
    }
}