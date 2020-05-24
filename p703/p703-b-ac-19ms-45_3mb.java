class KthLargest {

    private int k;
    private List<Integer> list;
    
    public KthLargest(int k, int[] nums) {
        this.k = k;
        Arrays.sort(nums);
        this.list = new ArrayList<Integer>();
        for (int i = nums.length - 1; i >= 0; i--) {
            this.list.add(nums[i]);
        }
    }
    
    public int add(int val) {
        
        if (list.size() > k - 1 && list.get(k - 1) >= val) {
            return list.get(k - 1);
        }
        
        int l = 0;
        int r = k - 1;
        
        while (l < r) {
            
            int m = l + ((r - l) / 2);
            
            int c = list.get(m);
            
            if (c > val) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        
        list.add(l, val);
        
        return list.get(k - 1);
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */