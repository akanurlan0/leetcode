class Solution {
    public boolean isPalindrome(String s) {
        
        char[] c = s.toCharArray();
        int l = 0;
        int r = c.length - 1;
        boolean result = true;
        
        while (l < c.length && r >= 0) {
            while (l < c.length && !Character.isAlphabetic(c[l]) && !Character.isDigit(c[l])) {
                l++;
            }
            
            while (r >= 0 && !Character.isAlphabetic(c[r]) && !Character.isDigit(c[r])) {
                r--;
            }
            
            if (r <= l) break;
            result = result && (Character.toUpperCase(c[l]) == Character.toUpperCase(c[r]));
            l++;
            r--;
        }
        
        return result;
    }
}