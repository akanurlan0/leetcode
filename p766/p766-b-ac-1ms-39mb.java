class Solution {
    public boolean isToeplitzMatrix(int[][] a) {
        
        int n = a.length;
        int m = a[n-1].length;
        
        int[] diagonalLatest = new int[n + m];
        for (int i = 0; i < n + m; i++) {
            diagonalLatest[i] = 100;
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                
                int diagonal;
                
                if (i > j) { // under main diagonal
                    diagonal = i - j + m - 1;
                } else { // main diagonal or above main diagonal
                    diagonal = j - i;
                }
                
                if (diagonalLatest[diagonal] == 100) {
                    diagonalLatest[diagonal] = a[i][j];
                } else 
                if (diagonalLatest[diagonal] != a[i][j]) {
                    return false;
                }
            }
        }
        
        return true;
        
    }
}