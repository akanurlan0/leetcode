class Solution {
    
    private int n;
    private int[] nums;
    private int[] pos;
    private List<List<Integer>> result;
    
    public List<List<Integer>> permute(int[] nums) {
        this.n = nums.length;
        this.nums = nums;
        this.pos = new int[n];
        for (int i = 0; i < n; i++) {
            this.pos[i] = Integer.MIN_VALUE;
        }
        this.result = new ArrayList<>();
        
        traverse(0);
        return result;
    }
    
    private void traverse(int index) {
        
        if (index == n) {
            int[] r = new int[n];
            for (int i = 0; i < n; i++) {
                r[pos[i]] = nums[i];
            }
            List<Integer> list = new ArrayList<>();
            for (int v : r) {
                list.add(v);
            }
            result.add(list);
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if (pos[i] == Integer.MIN_VALUE) {
                pos[i] = index;
                traverse(index + 1);
                pos[i] = Integer.MIN_VALUE;
            }
        }
    }
}