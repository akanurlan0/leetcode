class Solution {
    
    private int[] nums;
    
    public int numSquares(int n) {

        List<Integer> l = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            l.add(i * i);
        }
        
        int s = l.size();
        
        nums = new int[s];
        for (int i = 0; i < s; i++) {
            nums[i] = l.get(i);
        }
        
        int[] map = new int[n+1];
        
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] > i) break;
                min = Math.min(
                    min,
                    map[i - nums[j]] + 1
                );
            }
            map[i] = min;
        }
            
        return map[n];
    }
    
}