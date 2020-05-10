class Solution {
    public int findJudge(int N, int[][] trust) {
        int[] a = new int[N + 1];
        boolean[] b = new boolean[N + 1];
        
        int max = 0;
        int val = -1;
        
        for (int i = 0; i < trust.length; i++) {
            int out = trust[i][0];
            int in = trust[i][1];
            
            a[in]++;
            b[out] = true;
        }
        
        for (int i = 1; i <= N; i++) {
            if (a[i] == N - 1 && b[i] == false) {
                return i;
            }
        }
        
        return -1;
    }
}