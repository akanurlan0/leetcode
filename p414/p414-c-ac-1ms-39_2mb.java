class Solution {
    public int thirdMax(int[] nums) {
        Integer a = null;
        Integer b = null;
        Integer c = null;
        
        for (int n : nums) {
            if (a == null || a < n) {
                c = b;
                b = a;
                a = n;
            } 
            else if (a != n) {
                if (b == null || b < n) {
                    c = b;
                    b = n;
                } 
                else if (b != n) {
                    if (c == null || c < n) {
                        c = n;
                    }
                }
            }
        }
        
        if (c == null) return a;
        return c;
    }
}