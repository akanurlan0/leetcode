class Solution {
    public int removeElement(int[] nums, int val) {
        int l = 0;
        int r = nums.length - 1;
        
        while (l <= r) {
            if (nums[l] != val) {
                l++;
                continue;
            }
            
            int temp = nums[r];
            nums[r] = nums[l];
            nums[l] = temp;
            
            r--;
        }
        
        return r + 1;
    }
}