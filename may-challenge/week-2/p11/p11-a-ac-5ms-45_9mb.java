class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int n = image.length;
        int m = image[n-1].length;
        
        boolean[][] history = new boolean[n][m];
        
        int[][] q = new int[n*m][2];
        int l = 0;
        int r = 0;
        q[r][0] = sr; q[r][1] = sc; r++;
        history[sr][sc] = true;
        int oldColor = image[sr][sc];
        
        while (l < r) {
            int x = q[l][0];
            int y = q[l][1];
            
            if (image[x][y] != oldColor) {
                l++;
                continue;
            }
            
            image[x][y] = newColor;
            
            if (x > 0) {
                int xx = x - 1; int yy = y;
                if (history[xx][yy] == false) {
                    history[xx][yy] = true;
                    q[r][0] = xx; q[r][1] = yy; r++;
                }
            }
            if (x < n - 1) {
                int xx = x + 1; int yy = y;
                if (history[xx][yy] == false) {
                    history[xx][yy] = true;
                    q[r][0] = xx; q[r][1] = yy; r++;
                }
            }
            if (y > 0) {
                int xx = x; int yy = y - 1;
                if (history[xx][yy] == false) {
                    history[xx][yy] = true;
                    q[r][0] = xx; q[r][1] = yy; r++;
                }
            }
            if (y < m - 1) {
                int xx = x; int yy = y + 1;
                if (history[xx][yy] == false) {
                    history[xx][yy] = true;
                    q[r][0] = xx; q[r][1] = yy; r++;
                }
            }
            l++;
        }
        
        return image;
    }
}