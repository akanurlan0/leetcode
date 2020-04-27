class Solution {
    public int[] shortestToChar(String S, char C) {
        
        int n = S.length();
        
        int[] matches = new int[n];
        int m = 0;
        
        for (int i = 0; i < n; i++) {
            if (S.charAt(i) == C) {
                matches[m++] = i;
            }
        }
        
        int[] res = new int[n];
        
        int k = 0;
        
        for (int i = 0; i < n; i++) {
            int dist1 = matches[k] - i;
            if (dist1 < 0) {
                dist1 *= -1;
            }
            
            res[i] = dist1;
            
            int dist2 = n;
            if (k + 1 < m) {
                dist2 = matches[k + 1] - i;
            }
            
            if (dist2 < dist1) {
                res[i] = dist2;
                k++;
            }
        }
        
        return res;
    }
}