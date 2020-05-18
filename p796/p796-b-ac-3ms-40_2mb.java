class Solution {
    public boolean rotateString(String a, String b) {
        
        int[][] map = new int[255][255];
        
        int n = a.length();
        int m = b.length();
        
        for (int i = 0; i < n; i++) {
            map[code(a, i)][code(a, (i+1) % n)]++;
        }
        
        for (int i = 0; i < m; i++) {
            map[code(b, i)][code(b, (i+1) % m)]--;
        }
        
        for (int i = 0; i < 255; i++) {
            for (int j = 0; j < 255; j++) {
                if (map[i][j] != 0) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private int code(String s, int index) {
        return s.charAt(index);
    }
}