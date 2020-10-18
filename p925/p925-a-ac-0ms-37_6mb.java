class Solution {
    public boolean isLongPressedName(String name, String typed) {
        
        char[] n = name.toCharArray();
        char[] t = typed.toCharArray();
        
        int j = 0;
        
        for (int i = 0; i < n.length; i++) {
            
            if (j == t.length) {
                return false;
            }
            
            if (n[i] == t[j]) {
                j++;
                continue;
            }
            
            if (i > 0) {
                char prev = n[i - 1];
                while (prev == t[j]) {
                    j++;
                    if (j == t.length) {
                        return false;
                    }
                }
                if (n[i] == t[j]) {
                    j++;
                    continue;
                }
            }
            
            return false;
        }
        
        if (j != t.length) {
            char prev = n[n.length - 1];
            while (j < t.length && prev == t[j]) {
                j++;
            }
            return j == t.length;
        }
        
        return true;
    }
}