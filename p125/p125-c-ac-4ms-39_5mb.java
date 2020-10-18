class Solution {
    public boolean isPalindrome(String s) {
        
        int n = s.length();
        int l = 0;
        int r = s.length() - 1;
        boolean result = true;
        
        while (l < n && r >= 0) {
            if (!Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            }
            else if (!Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            }
            else if (Character.toUpperCase(s.charAt(l)) != Character.toUpperCase(s.charAt(r))) {
                result = false;
                break;
            } 
            else {
                l++;
                r--;
            }
        }
        
        return result;
    }
}