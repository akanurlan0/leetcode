class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        return partition(nums, 0, nums.length - 1, nums.length - k);
    }
    
    private int partition(int[] nums, int lo, int hi, int k) { // lo = 0, hi = 5, k = 6 - 3 = 3
        int pivot = lo; // pivot = 3
        
        int val = nums[k]; // val = 4
        swap(nums, k, hi); 
        
        for (int i = lo; i < hi; i++) {
            if (nums[i] < val) {
                swap(nums, i, pivot++);
            }
        }
        
        swap(nums, pivot, hi);
        
        if (pivot == k) return nums[k];
        
        if (pivot > k) return partition(nums, lo, pivot - 1, k); // nums, lo = 3, hi = 3, k = 3
        else return partition(nums, pivot + 1, hi, k); // nums, lo = 3, hi = 5, k = 3
    }
    
    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
