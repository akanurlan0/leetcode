class Solution {
    public int rob(int[] nums) {
        int even = 0;
        int odd = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int add = 0;
            if (i - 2 >= 0) {
                add = Math.max(add, nums[i-2]);
            }
            if (i - 3 >= 0) {
                add = Math.max(add, nums[i-3]);
            }
            nums[i] += add;
            max = Math.max(max, nums[i]);
        }
        
        return max;
    }
}