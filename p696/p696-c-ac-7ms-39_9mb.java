class Solution {
    public int countBinarySubstrings(String s) {
        
        int n = s.length();
        
        int prev2 = 0;
        int prev1 = 1;
        int res = 0;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                prev1++;
            } else {
                res += prev1 > prev2 ? prev2 : prev1;
                prev2 = prev1;
                prev1 = 1;
            }
            // System.out.println(prev1 + " " + prev2);
        }
        res += prev1 > prev2 ? prev2 : prev1;
        
        return res;
        
    }
}