class Solution {
    public String reverseOnlyLetters(String s) {
        
        int n = s.length();
        
        int[] letters = new int[n];
        int[] nonletters = new int[n];
        int size1 = 0;
        int size2 = 0;
        
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            boolean isLetter = isLetter(c);
            if (isLetter) {
                letters[size1++] = i;
            } else {
                nonletters[size2++] = i;
            }
        }
        
        int p1 = size1 - 1;
        int p2 = 0;
        
        char[] res = new char[n];
        
        for (int i = 0; i < n; i++) {
            if (size2 > 0 && nonletters[p2] == i) {
                res[i] = s.charAt(nonletters[p2]);
                p2++;
            } else {
                res[i] = s.charAt(letters[p1]);
                p1--;
            }
        }
        
        return new String(res);
    }
    
    private boolean isLetter(char a) {
        int code = (int) a;
        
        if (65 <= code && code <= 90) return true;
        if (97 <= code && code <= 122 ) return true;
        
        return false;
    }
}