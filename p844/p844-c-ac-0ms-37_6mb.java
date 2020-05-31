class Solution {
    public boolean backspaceCompare(String a, String b) {

        int n = a.length() - 1;
        int m = b.length() - 1;
        
        while (n >= 0 || m >= 0) {
            
            int bsc = 0;
            char c1 = '\0';

            while (n >= 0) {
                if (a.charAt(n) == '#') {
                    bsc++;
                    n--;
                } else 
                if (bsc > 0) {
                    bsc--;
                    n--;
                } else {
                    c1 = a.charAt(n);
                    break;
                }
            }
            
            bsc = 0;
            char c2 = '\0';

            while (m >= 0) {
                if (b.charAt(m) == '#') {
                    bsc++;
                    m--;
                } else 
                if (bsc > 0) {
                    bsc--;
                    m--;
                } else {
                    c2 = b.charAt(m);
                    break;
                }
            }
            
            if (c1 != c2) {
                return false;
            }
            
            n--;
            m--;
        }
        
        return true;
    }
}