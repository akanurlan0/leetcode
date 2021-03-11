class Solution {
    public String countAndSay(int n) {
        
        StringBuilder s = new StringBuilder("1");
        
        for (int i = 2; i <= n; i++) {
            
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
        }
        
        return s.toString();
    }
}