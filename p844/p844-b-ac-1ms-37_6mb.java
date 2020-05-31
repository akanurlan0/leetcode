class Solution {
    public boolean backspaceCompare(String S, String T) {
        char[] a = S.toCharArray();
        char[] b = T.toCharArray();
        int n = a.length - 1;
        int m = b.length - 1;
        
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        
        for (int i = 0; i < a.length; i++) {
            if (a[i] == '#') {
                if (s1.length() > 0) s1.setLength(s1.length() - 1);
            } else {
                s1.append(a[i]);
            }
        }
    
        for (int i = 0; i < b.length; i++) {
            if (b[i] == '#') {
                if (s2.length() > 0) s2.setLength(s2.length() - 1);
            } else {
                s2.append(b[i]);
            }
        }
        
        return s1.toString().equals(s2.toString());
    }
}