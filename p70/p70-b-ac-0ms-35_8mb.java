class Solution {
    public int climbStairs(int n) {
        int step0 = 0;
        int step1 = 1;
        int step2 = 0;
        
        for (int i = 1; i <= n; i++) {
            step2 = step0 + step1;
            step0 = step1;
            step1 = step2;
        }
        
        return step2;
    }
}