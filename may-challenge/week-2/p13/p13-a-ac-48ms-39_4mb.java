class Solution {
    public String removeKdigits(String num, int k) {

        int n = num.length();
        
        char[] c = num.toCharArray();
        boolean[] ex = new boolean[n];
        
        for (int j = 0; j < k; j++) {
            
            int index = -1;
            int prev = -1;
            for (int i = 0; i < n; i++) {
                if (ex[i]) {
                    continue;
                }
                
                if (prev != -1 && c[prev] > c[i]) {
                    index = prev;
                    break;
                }

                index = i;
                prev = i;
            }
            
            ex[index] = true;
        }
        
        StringBuilder sb = new StringBuilder();
        
        boolean leadingNonZero = false;
        for (int i = 0; i < n; i++) {
            if (ex[i]) {
                continue;
            }
            if (c[i] == '0' && leadingNonZero) {
                sb.append(c[i]);
            } else
            if (c[i] != '0') {
                sb.append(c[i]);
                leadingNonZero = true;
            }
        }
        
        if (sb.length() == 0) {
            sb.append('0');
        }
        
        return sb.toString();
    }
}