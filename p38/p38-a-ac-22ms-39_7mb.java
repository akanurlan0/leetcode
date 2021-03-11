class Solution {
    public String countAndSay(int n) {
        
        String s = "1";
        
        for (int i = 2; i <= n; i++) {
            
            String nextStr = "";
            
            char[] c = s.toCharArray();
            int j = 0;
            while (j < c.length) {
                
                int k = j;
                while (k + 1 < c.length && c[k + 1] == c[j]) {
                    k++;
                }
                
                nextStr += Integer.toString(k - j + 1);
                nextStr += c[j];
                
                j += k - j + 1;
            }
            
            s = nextStr;
        }
        
        return s;
    }
}