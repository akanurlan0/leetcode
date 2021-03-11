class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] map = new boolean[n];
        map[0] = true;
        
        for (int i = 0; i < n; i++) {
            if (!map[i]) continue;
            int a = nums[i];
            for (int j = 1; j <= a; j++) {
                if (i + j == n) break;
                map[i + j] = true;
            }
        }
        
        return map[n-1];
    }
}