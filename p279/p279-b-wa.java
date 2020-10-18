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
            nums[i] = l.get(s - 1 - i);
        }
        
        return dfs(n, 0, 0);
    }
    
    private int dfs(int rem, int index, int count) {
        
        if (rem == 0) {
            return count;
        }
        if (index == nums.length) return -1;
        
        int curr = nums[index];
        int k = rem / curr;
        
        for (int i = k; i >= 0; i--) {
            int res = dfs(rem - (curr * i), index + 1, count + i);
            if (res > -1) {
                return res;
            }
        }
        
        return -1;
    }
}