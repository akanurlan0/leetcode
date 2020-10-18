class Solution {
    public String longestPalindrome(String s) {
        int lMax = 0;
        int rMax = -1;
        
        int l = 0;
        int r = 0;
        
        char[] c = s.toCharArray();
        
        for (int i = 0; i < c.length; i++) {
            
            l = i;
            r = i;
            while (l >=0 && r < c.length && c[l] == c[r]) {
                if (r - l > (rMax - lMax)) {
                    rMax = r;
                    lMax = l;
                }
                l--;
                r++;
            }
            
            l = i;
            r = i + 1;
            while (l >=0 && r < c.length && c[l] == c[r]) {
                if (r - l > (rMax - lMax)) {
                    rMax = r;
                    lMax = l;
                }
                l--;
                r++;
            }
        }
        
        return s.substring(lMax, rMax + 1);
    }
}