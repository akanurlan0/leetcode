class Solution {
    public int rob(int[] nums) {
        int even = 0;
        int odd = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((i & 1) == 0) {
                odd += nums[i];
            } else {
                even += nums[i];
            }
        }
        
        return Math.max(odd, even);
    }
}