class Solution {
    public int uniquePaths(int m, int n) {
        int[] map = new int[n];
        map[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                map[j] += map[j-1];
            }
        }

        return map[n - 1];
    }
}