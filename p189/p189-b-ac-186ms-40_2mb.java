class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        for (int j = 0; j < k; j++) {
            int swap = nums[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                nums[i + 1] = nums[i];
            }
            nums[0] = swap;
        }
    }
}