class Solution {
    public void moveZeroes(int[] nums) {
        
        int zi = 0;
        int nzi = 0;
        int n = nums.length;
        
        while (nzi < n) {
            if (nums[nzi] == 0) {
                nzi++;
                continue;
            }
            
            while (zi < n && nums[zi] != 0) {
                zi++;
            }
            if (zi > nzi) {
                nzi++;
                continue;
            }
            
            int tmp = nums[nzi];
            nums[nzi] = nums[zi];
            nums[zi] = tmp;
        }
    }
}