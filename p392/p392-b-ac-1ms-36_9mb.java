class Solution {
    
    public boolean isSubsequence(String s, String t) {
        int p = 0;
        for (int i = 0; i < t.length() && p < s.length(); i++) {
            if (s.charAt(p) == t.charAt(i)) {
                p++;
            }
        }
        
        return p == s.length();
    }
}