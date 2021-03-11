class Solution {
    public int subarraySum(int[] nums, int k) {
        
        int n = nums.length;
        
        int[] sums = new int[n];
        sums[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            sums[i] = sums[i + 1] + nums[i];
        }
        
        int counter = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (sums[i] - sums[j] == k) counter++;
            }
            if (sums[i] == k) counter++;
        }
        
        return counter;
    }
}