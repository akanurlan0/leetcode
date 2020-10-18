class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        // 1,2,3,0,0,0
        // 2,5,6
        
        // 1,2,^3,0,0,6
        // 2,^5,6
        
        // 1,2,^3,0,5,6
        // ^2,5,6
        
        // 1,^2,3,3,5,6
        // ^2,5,6
        
        // 1,^2,2,3,5,6
        // 2,5,6
        
        int index = nums1.length - 1;
        
        m--;
        n--;
        
        while (n >= 0) {
            if (m < 0 || nums1[m] <= nums2[n]) {
                nums1[index] = nums2[n--];
            } 
            else if (nums1[m] > nums2[n]) {
                nums1[index] = nums1[m--];
            }
            index--;
        }
    }
}