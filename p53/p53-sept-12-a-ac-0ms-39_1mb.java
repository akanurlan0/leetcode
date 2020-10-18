class Solution {
    public int maxSubArray(int[] nums) {
        
        int max = Integer.MIN_VALUE;
        int localMax = 0;
        for (int n : nums) {
            
            // [-2,1,-3,4,-1,2,1,-5,4]
            //-2 : lm = -2, max = -2
            // 1 : lm = 1, max = 1
            //-3 : lm = -3, max = 1
            // 4 : lm = 4, max = 4
            //-1 : lm = 3, max = 4
            // 2 : lm = 5, max = 5
            // 1 : lm = 6, max = 6

            if (localMax > 0 && localMax + n > 0){ 
                localMax += n;
            } else {
                localMax = n;
            }

            if (localMax > max) {
                max = localMax;
            }
        }
        
        return max;
        
    }
}