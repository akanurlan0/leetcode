class Solution {
    public String longestDupSubstring(String s) {
        
        char[] c = s.toCharArray();
        int n = c.length;
        int l = 0;
        int r = n - 1;
        
        int globalMaxLen = 0;
        String globalMaxKey = "";
        
        while (l <= r) {
            int m = l + (r - l) / 2;
            
            // System.out.println("--------------");
            // System.out.println(l + " " + r + " " + m);
            
            int localMaxCount = 0;
            String localMaxKey = null;
            
            Map<String, Integer> map = new HashMap<String, Integer>();
            for (int i = 0; i <= n - m; i++) {
                
                String k = s.substring(i, i + m);
                // System.out.println(k);
                Integer v = map.getOrDefault(k, 0) + 1;
                
                map.put(k, v);
                if (localMaxCount < v) {
                    localMaxCount = v;
                    localMaxKey = k;
                }
            }
            
            if (localMaxCount < 2) {
                r = m - 1;
            } else {
                l = m + 1;
                if (globalMaxLen < m) {
                    globalMaxLen = m;
                    globalMaxKey = localMaxKey;
                }
            }
        }
        
        return globalMaxKey;        
    }
}