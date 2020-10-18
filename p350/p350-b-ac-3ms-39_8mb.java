class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // case 1. if two arrays are sorted
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int p1 = 0;
        int p2 = 0;
        
        List<Integer> list = new ArrayList<>();
        
        while (p1 < nums1.length && p2 < nums2.length) {
            
            int compare = Integer.compare(nums1[p1], nums2[p2]);
            
            switch (compare) {
                case 0:
                    list.add(nums1[p1]);
                    p1++;
                    p2++;
                    break;
                case 1:
                    p2++;
                    break;
                case -1:
                    p1++;
                    break;
            }
        }
        
        int[] res = new int[list.size()];
        int i = 0;
        for (Integer num : list) {
            res[i++] = num;
        }
        return res;
    }
}