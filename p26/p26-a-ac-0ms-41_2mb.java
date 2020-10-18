class Solution {
    public int removeDuplicates(int[] nums) {
        int result = nums.length;
        
        // [1,1,2]
        // [0,0,1,1,1,2,2,3,3,4]
        
        int nextIndex = 0;
        for (int i = 0; i < nums.length; i++) {            
            if (i > 0 && nums[i] == nums[i-1]) {
                result--;
            } else {
                nums[nextIndex++] = nums[i];
            }
        }
        return result;
    }
}