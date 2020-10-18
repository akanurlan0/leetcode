class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        
        char[] c = s.toCharArray();
        
        int result = 0;
        
        int[][] map = new int[n][n];
        for (int len = 2; len <= n; len += 2) {
            for (int l = 0; l < n; l++) {
                int r = l + len - 1;
                if (r >= n) break;
                
                int case1 = 0;
                if (c[l] == '(' && c[r] == ')') {
                    if (l + 1 == r) {
                        case1 = 2;
                    } else 
                    if (map[l + 1][r - 1] > 0) {
                        case1 = 2 + map[l + 1][r - 1];
                    }
                }
                
                int case2 = 0;
                for (int k = 2; k <= len; k += 2) {
                    int l1 = l;
                    int r1 = l + k - 1;
                    int l2 = l + k;
                    int r2 = r;
                    if (l2 >= r2) break;
                    if (map[l1][r1] > 0 && map[l2][r2] > 0) {
                        case2 = Math.max(case2, map[l1][r1] + map[l2][r2]);
                    }
                }
                
                map[l][r] = Math.max(case1, case2);
                
                result = Math.max(result, map[l][r]);
            }
        }
        
        return result;
    }
}