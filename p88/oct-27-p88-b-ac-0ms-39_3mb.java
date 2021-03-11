class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int len = m + n;
        
        m--;
        n--;
        
        for (int i = len - 1; i >= 0; i--) {
            int val;
            if (m > -1 && n > -1) {
                if (nums1[m] > nums2[n]) {
                    val = nums1[m--];
                } else {
                    val = nums2[n--];
                }
            } else
            if (m > -1) {
                val = nums1[m--];
            } else {
                val = nums2[n--];
            }
            
            nums1[i] = val;
        }
    }
}