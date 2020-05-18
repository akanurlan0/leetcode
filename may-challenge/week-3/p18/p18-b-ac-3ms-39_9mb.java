class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        int len1 = s1.length(); int len2 = s2.length();
        int[] map = new int[26];
        
        for (int i = 0; i < len1; i++) {
            map[code(s1, i)]++;
        }
        
        for (int i = 0; i < len2; i++) {
            
            if (i >= len1) {
                map[code(s2, i - len1)]++;
            }
            
            map[code(s2, i)]--;
            
            if (allZero(map)) {
                return true;
            }
        }
        
        return false;
    }
    
    private boolean allZero(int[] map) {
        for (int i = 0; i < 26; i++) {
            if (map[i] != 0) return false;
        }
        return true;
    }
    
    private int code(String s, int index) {
        return s.charAt(index) - 'a';
    }
}