class Solution {
    

    public boolean possibleBipartition(int N, int[][] dislikes) {
        int[] c = new int[N + 1];
        
        int[] q = new int[N];
        int r = 0;
        
        while (true) {
            
            boolean flag = true;
            
            for (int i = 1; i <= N; i++) {
                if (c[i] == 0) {
                    q[r++] = i;
                    c[i] = 1;
                    flag = false;
                    break;
                }
            }
            
            if (flag) break;

            int l = 0;
            while (l < r) {
                int n = q[l++];

                int nextVal = c[n] == 1 ? 2 : 1;

                for (int i = 0; i < dislikes.length; i++) {
                    int next = -1;

                    if (dislikes[i][0] == n) {
                        next = dislikes[i][1];
                    } else
                    if (dislikes[i][1] == n) {
                        next = dislikes[i][0];
                    }

                    if (next == -1) continue;

                    if (c[next] == 0) {
                        q[r++] = next;
                        c[next] = nextVal;
                    } else if (c[next] == c[n]) {
                        return false;
                    }
                }
            }
            
        }
        
        return true;
    }
}