class Solution {
    
    private static String[] results = null;
    
    public String countAndSay(int n) {
        
        if (results == null) {
            precalc();
        }
        
        return results[n];
    }
    
    private void precalc() {
        
        results = new String[31];
        
        StringBuilder s = new StringBuilder("1");
        results[1] = s.toString();
        
        for (int i = 2; i <= 30; i++) {
            
            int len = s.length();
            
            int j = 0;
            while (j < len) {
                
                int k = j;
                while (k + 1 < len && s.charAt(k + 1) == s.charAt(j)) {
                    k++;
                }
                
                s.append(k - j + 1);
                s.append(s.charAt(j));
                
                j += k - j + 1;
            }
            
            s = s.delete(0, len);
            results[i] = s.toString();
        }
    }
}