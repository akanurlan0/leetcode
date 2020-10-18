class Solution {
    public boolean isLongPressedName(String name, String typed) {
        
        List<Pair> n = transform(name);
        List<Pair> t = transform(typed);

        if (n.size() != t.size()) return false;
        
        for (int i = 0; i < n.size(); i++) {
            
            Pair p1 = n.get(i);
            Pair p2 = t.get(i);
            
            if (p1.c != p2.c) return false;
            
            if (p1.p > p2.p) return false;
        }
        
        return true;
    }

    private List<Pair> transform(String s) {
        List<Pair> res = new ArrayList<>();
        
        int i = 0;
        char c = s.charAt(i);
        int p = 1;
        
        while (++i < s.length()) {
            if (s.charAt(i) == c) p++;
            else {
                res.add(new Pair(c, p));
                c = s.charAt(i);
                p = 1;
            }
        }
        
        res.add(new Pair(c, p));
        
        return res;
    }
        
    class Pair {
        public final char c;
        public final int p;
        
        public Pair(char c, int p) {
            this.c = c;
            this.p = p;
        }
    }
    
}