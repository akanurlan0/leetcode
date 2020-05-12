class Solution {
    
    private int n, m;
    private int[][] image;
    private boolean[][] history;
    private int oldColor, newColor;
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        n = image.length; m = image[n-1].length;
        this.image = image;
        history = new boolean[n][m];
        history[sr][sc] = true;
        oldColor = image[sr][sc];
        this.newColor = newColor;
        
        fill(sr, sc);
        
        return image;
    }
    
    private void fill(int x, int y) {
                    
        if (image[x][y] != oldColor) {
            return;
        }

        image[x][y] = newColor;
        
        if (x > 0) {
            int a = x - 1; int b = y;
            if (history[a][b] == false) {
                history[a][b] = true;
                fill(a, b);
            }
        }
        if (x < n - 1) {
            int a = x + 1; int b = y;
            if (history[a][b] == false) {
                history[a][b] = true;
                fill(a, b);
            }
        }
        if (y > 0) {
            int a = x; int b = y - 1;
            if (history[a][b] == false) {
                history[a][b] = true;
                fill(a, b);
            }
        }
        if (y < m - 1) {
            int a = x; int b = y + 1;
            if (history[a][b] == false) {
                history[a][b] = true;
                fill(a, b);
            }
        }
    }
}