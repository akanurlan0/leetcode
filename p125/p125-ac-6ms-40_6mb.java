class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            Character c = normalized(s.charAt(i));
            if (c != null) {
                sb.append(c);
            }
        }
        
        int m = sb.length();
        
        boolean res = true;
        for (int i = 0; i < m/2; i++) {
            if (sb.charAt(i) != sb.charAt(m - 1 - i))  {
                res = false;
                break;
            }
        }
        
        return res;
    }
    
    private Character normalized(char c) {
        if (Character.isAlphabetic(c)) {
            return Character.toUpperCase(c);
        } else 
        if (Character.isDigit(c)) {
            return c;
        } else {
            return null;
        }
    }
}