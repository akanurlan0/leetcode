class Solution {
    public int countBinarySubstrings(String s) {
        
        int n = s.length();
        
        int[] a = new int[n];
        int len = 0;
        
        a[len++] = 1;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                a[len-1]++;
            } else {
                a[len++] = 1;
            }
        }
        
        int res = 0;
        for (int i = 0; i < len - 1; i++) {
            res += a[i + 1] > a[i] ? a[i] : a[i + 1];
        }
        
        return res;
        
    }
}