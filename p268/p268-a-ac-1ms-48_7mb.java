class Solution {
    public int missingNumber(int[] nums) {
        
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += i + 1 - nums[i]; 
        }
        
        return sum;
    }
}