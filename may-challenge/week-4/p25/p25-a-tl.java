class Solution {
    
    private int[] a, b;
    private int res;
    
    public int maxUncrossedLines(int[] A, int[] B) {
        this.a = A;
        this.b = B;
        this.res = 0;
        
        traverse(0, 0, 0);
        
        return res;
    }
    
    private void traverse(int x, int y, int sum) {
        
        if (res < sum) {
            res = sum;
        }
        
        if (x == a.length || y == b.length) {
            return;
        }
        
        for (int i = x; i < a.length; i++) {
            for (int j = y; j < b.length; j++) {
                if (a[i]==b[j]) {
                    traverse(i + 1, j + 1, sum + 1);
                }
            }
        }
    }
}