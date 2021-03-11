class Solution {
    public int minMoves(int[] nums) {
        
        int n = nums.length;
        
        
        int counter = 0;
        
        while (true) {
            
            Arrays.sort(nums);
            
            int min = nums[0];
            int max = nums[n - 1];
            
            int diff = max - min;
            if (diff == 0) break;
            
            counter += diff;
            
            for (int i = 0; i < n - 1; i++) {
                nums[i] += diff;
            }
        }
        
        return counter;
    }
}