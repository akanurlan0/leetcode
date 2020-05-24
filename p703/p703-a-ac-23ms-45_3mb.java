class KthLargest {

    private int k;
    private List<Integer> list;
    
    public KthLargest(int k, int[] nums) {
        this.k = k;
        Arrays.sort(nums);
        this.list = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            this.list.add(nums[i]);
            // System.out.print(nums[i] + " ");
        }
        // System.out.println();
    }
    
    public int add(int val) {
        
        int l = 0;
        int r = list.size();
        
        while (l < r) {
            
            int m = l + ((r - l) / 2);
            
            int c = list.get(m);
            
            if (c > val) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        
        list.add(l, val);
        
//         for (int i = 0; i < list.size(); i++) {
//             System.out.print(list.get(i) + " ");
//         }
//         System.out.println();
        
        return list.get(list.size() - k);
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */