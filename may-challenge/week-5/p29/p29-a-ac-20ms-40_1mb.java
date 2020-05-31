class Solution {
    
    int n;
    byte[] color;
    int[][] p;
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        this.n = numCourses;
        this.p = prerequisites;
        
        color = new byte[n+1];
        
        boolean good = true;
        
        for (int i = 1; i <= n; i++) {
            if (color[i] == 0 && dfs(i) == false) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean dfs(int v) {
        
        color[v] = 1;
        
        for (int i = 0; i < p.length; i++) {
            if (p[i][0] == v) {
                int nextV = p[i][1];
                if (color[nextV] == 0) {
                    if (dfs(nextV) == false) return false;
                } else 
                if (color[nextV] == 1) {
                    return false;
                }
            }
        }
        
        color[v] = 2;
        
        return true;
    }
}