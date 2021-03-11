class Solution {

    public static void main(String[] args) {

        System.out.println(
            new Solution().totalFruit(new int[] {1,0,1,4,1,4,1,2,3})
        );
    }

    public int totalFruit(int[] a) {
        
        int n = a.length;
        int max = Integer.MIN_VALUE;
        
        int l1 = -1; 
        int r1 = -1;
        int l2 = -1;
        int r2 = -1;
        
        for (int i = 0; i < n; i++) {
            
            // [1,0,1,4,1,4,1,2,3]
            //            ^
            // i: 5
            // l1: 2
            // r1: 4
            // l2: 3
            // r2: 5
            // max: 4
            
            if (l1 == -1) {
                l1 = i;
                r1 = i;
                
                max = Math.max(max, Math.max(r1, r2) - l1 + 1);
                continue;
            }
            
            if (a[l1] == a[i]) {
                r1 = i;
                max = Math.max(max, Math.max(r1, r2) - l1 + 1);
                continue;
            }
            
            if (l2 == -1) {
                l2 = i;
                r2 = i;
                max = Math.max(max, Math.max(r1, r2) - l1 + 1);
                continue;
            }
            
            if (a[l2] == a[i]) {
                r2 = i;
                max = Math.max(max, Math.max(r1, r2) - l1 + 1);
                continue;
            }
            
            if (r1 < l2) {
                l1 = l2;
                r1 = r2;
                l2 = i;
                r2 = i;
                max = Math.max(max, Math.max(r1, r2) - l1 + 1);
                continue;
            }
            
            if (r2 < r1) {
                l1 = r2 + 1;
                r1 = r1;
                l2 = i;
                r2 = i;
                max = Math.max(max, Math.max(r1, r2) - l1 + 1);
                continue;
            }
            
            l1 = r1 + 1;
            r1 = r2;
            l2 = i;
            r2 = i;
            max = Math.max(max, Math.max(r1, r2) - l1 + 1);
        }
        
        return max;
    }
}