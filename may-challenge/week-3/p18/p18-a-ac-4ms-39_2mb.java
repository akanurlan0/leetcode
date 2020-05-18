class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        int len1 = s1.length();
        int[] map1 = new int[26];
        for (int i = 0; i < len1; i++) {
            map1[code(s1, i)]++;
        }
        
        int[] map2 = new int[26];
        for (int i = 0; i < s2.length(); i++) {
            
            map2[code(s2, i)]++;
            
            if (i >= len1) {
                map2[code(s2, i - len1)]--;
            }
            
            boolean flag = true;
            for (int j = 0; j < 26; j++) {
                if (map1[j] != map2[j]) {
                    flag = false;
                    break;
                }
            }
            
            if (flag) {
                return true;
            }
        }
        
        return false;
    }
    
    private int code(String s, int index) {
        return s.charAt(index) - 'a';
    }
}