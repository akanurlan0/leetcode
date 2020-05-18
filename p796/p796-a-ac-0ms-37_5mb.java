class Solution {
    public boolean rotateString(String a, String b) {
        
        if (a.length() != b.length()) {
            return false;
        }
        
        if (a.equals(b)) {
            return true;
        }
        
        int n = a.length();
        
        for (int i = 1; i < n; i++) {
            
            boolean good = true;
            
            for (int j = 0; j < n; j++) {
                
                int aIndex = (i + j) % n;
                if (a.charAt(aIndex) != b.charAt(j)) {
                    good = false;
                    break;
                }
            }
            
            if (good) {
                return true;
            }
        }
        
        return false;
    }
}