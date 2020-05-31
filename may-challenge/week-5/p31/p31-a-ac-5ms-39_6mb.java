class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        
        int[][] map = new int[n+1][m+1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    map[i][j] = Math.max(i, j);
                    continue;
                }
                
                map[i][j] = Math.min(
                    Math.min(
                        map[i-1][j] + 1,
                        map[i][j-1] + 1
                    ),
                    map[i-1][j-1] + (word1.charAt(i-1) == word2.charAt(j-1) ? 0 : 1)
                );
            }
        }
        
        return map[n][m];
    }
}