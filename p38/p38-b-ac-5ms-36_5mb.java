class Solution {
    public String countAndSay(int n) {
        
        StringBuilder s = new StringBuilder("1");
        StringBuilder nextStr = new StringBuilder();
        
        for (int i = 2; i <= n; i++) {
            
            int j = 0;
            while (j < s.length()) {
                
                int k = j;
                while (k + 1 < s.length() && s.charAt(k + 1) == s.charAt(j)) {
                    k++;
                }
                
                nextStr.append(k - j + 1);
                nextStr.append(s.charAt(j));
                
                j += k - j + 1;
            }
            
            s = new StringBuilder(nextStr);
            nextStr = new StringBuilder();
        }
        
        return s.toString();
    }
}