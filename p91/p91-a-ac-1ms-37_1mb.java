class Solution {
    public int numDecodings(String s) {
        
        char[] c = s.toCharArray();
        int n = c.length;
    
        int[] a = new int[n];
        a[0] = isValid(c[0]) ? 1 : 0;

        for (int i = 1; i < n; i++) {
            
            if (isValid(c[i])) {
                a[i] += a[i - 1];
            }
            if (isValid(c[i-1], c[i])) {
                a[i] += i - 2 < 0 ? 1 : a[i - 2];
            }
        }
        
        return a[n - 1];
    }
    
    private boolean isValid(char c) {
        int digit = c - '0';
        return digit > 0 && digit < 27;
    }
    
    private boolean isValid(char c1, char c2) {
        if (c1 == '0') return false;
        int num = (c1 - '0') * 10;
        num += c2 - '0';
        return num > 0 && num < 27;
    }
}