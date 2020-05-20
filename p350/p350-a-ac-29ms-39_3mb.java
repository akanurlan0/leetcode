class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        int[] a = nums1;
        int[] b = nums2;
        
        Arrays.sort(a);
        
        List<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < a.length; i++) {
            list.add(a[i]);
            System.out.print(a[i] + " ");
        }
        System.out.println();
        
        List<Integer> res = new ArrayList<Integer>();
        
        for (int i = 0; i < b.length; i++) {
            int l = 0;
            int r = list.size() - 1;
            while (list.size() > 0 && l <= r) {
                int m = l + ((r - l)/2);
                int v = list.get(m);
                if (v < b[i]) {
                    l = m + 1;
                } else 
                if (v > b[i]) {
                    r = m - 1;
                } else {
                    res.add(v);
                    list.remove(m);
                    break;
                }
            }
        }
        
        int[] resArray = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resArray[i] = res.get(i);
        }
        return resArray;
    }
}