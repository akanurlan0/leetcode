class Solution {
    
    private String s, t;
    
    public boolean isSubsequence(String s, String t) {
        this.s = s;
        this.t = t;
        
        return check(0, 0);
    }
    
    private boolean check(int a, int b) {
    
        if (a == s.length()) {
            return true;
        }
 
        if (b == t.length()) {
            return false;
        }
              
        boolean res = false;
        
        for (int i = b; i < t.length(); i++) {
            if (s.charAt(a) == t.charAt(i)) {
                boolean l = check(a + 1, i + 1);
                if (l) {
                    res = true;
                    break;
                }
            }
        }
        
        return res;
    }
}