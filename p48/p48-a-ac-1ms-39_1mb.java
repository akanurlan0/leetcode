class Solution {

    public void rotate(int[][] matrix) {
        rotateRec(matrix);
    }
    
    private void rotateRec(int[][] matrix) {
        
        int size = matrix.length;
        
        if (size <= 1) return;
        
        int shift   = shift(size);
        int half    = half(size);
        
        int x0 = 0;
        int y0 = 0;
        
        int x1 = shift;
        int y1 = 0;
        
        int x2 = shift;
        int y2 = shift;
        
        int x3 = 0;
        int y3 = shift;
        
        int[][] m0 = submatrix(matrix, x0, y0, half);
        int[][] m1 = submatrix(matrix, x1, y1, half);
        int[][] m2 = submatrix(matrix, x2, y2, half);
        int[][] m3 = submatrix(matrix, x3, y3, half);
        
        rotateRec(m0);
        rotateRec(m1);
        rotateRec(m2);
        rotateRec(m3);
        
        put(matrix, x0, y0, half, m3);
        put(matrix, x3, y3, half, m2);
        put(matrix, x2, y2, half, m1);
        put(matrix, x1, y1, half, m0);
    }
    
    private int[][] submatrix(int[][] matrix, int x, int y, int size) {
        int[][] res = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                res[i][j] = matrix[y + i][x + j];
            }
        }
        return res;
    }
    
    private void put(int[][] matrix, int x, int y, int size, int[][] source) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[y + i][x + j] = source[i][j];
            }
        }
    }
    
    private int shift(int number) {
        return number / 2;
    }
    
    private int half(int number) {
        int res = number / 2;
        if (number % 2 == 1) res++;
        return res;
    }
}