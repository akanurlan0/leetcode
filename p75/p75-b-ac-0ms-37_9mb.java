class Solution {
    public void sortColors(int[] nums) {
        int l = 0;
        int m = 0;
        int r = nums.length - 1;
        
        while (m <= r) {
            // debug(nums, l, m ,r);
            
            if (nums[m] == 0) {
                swap(nums, l, m);
                l++;
                m++;
            } else
            if (nums[m] == 2) {
                swap(nums, m, r);
                r--;
            } else {
                m++;
            }
        }
        
        // debug(nums, l, m ,r);
    }
    
    private void swap(int[] nums, int i1, int i2) {
        int tmp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = tmp;
    }
    
    private void debug(int[] nums, int l, int m, int r) {
        System.out.println("-----------------");
        System.out.println("l: " + l + ", m: " + m + ", r: " + r);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}
