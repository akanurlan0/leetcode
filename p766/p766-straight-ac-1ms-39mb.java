class Solution {
    public boolean isToeplitzMatrix(int[][] a) {
        
        int n = a.length;
        int m = a[n-1].length;
        
        int x = n - 1;
        int y = 0;
        
        while (x >= 0 && y < m) {
            
            boolean flag = true;
            int i = x;
            int j = y;
            int prev = 100;
            while (i < n && j < m) {
                if (prev != 100 && prev != a[i][j]) {
                    flag = false;
                    break;
                }
                prev = a[i][j];
                i++;
                j++;
            }
            
            if (flag == false) {
                return false;
            }
            
            if (x > 0) {
                x--;
            } else {
                y++;
            }
        }
        
        return true;
    }
}