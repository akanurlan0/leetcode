class Solution {
    public int minMoves(int[] nums) {
        
        int n = nums.length;
        
        int counter = 0;
        
        while (true) {
            
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            int maxInd = -1;
            for (int i = 0; i < n; i++) {
                min = Math.min(min, nums[i]);
                if (max < nums[i]) {
                    max = nums[i];
                    maxInd = i;
                }                
            }
            
            int temp = nums[n-1];
            nums[n-1] = nums[maxInd];
            nums[maxInd] = temp;
            
            n--;
            
            int diff = max - min;
            if (diff == 0) break;
            
            counter += diff;
            
            for (int i = 0; i < n; i++) {
                nums[i] += diff;
            }
        }
        
        return counter;
    }
}