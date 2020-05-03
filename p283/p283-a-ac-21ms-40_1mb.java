class Solution {
    public void moveZeroes(int[] nums) {
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) continue;
            
            int zi = i;
            for (int j = 0; j < i; j++) {
                if (nums[j] == 0) {
                    zi = j;
                    break;
                }
            }
            if (zi == i) continue;
            
            int tmp = nums[i];
            nums[i] = nums[zi];
            nums[zi] = tmp;
        }
    }
}