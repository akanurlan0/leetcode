class Solution {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        
        Stack<StringBuilder> sbs = new Stack<StringBuilder>();
        Stack<Integer> counts = new Stack<Integer>();
        sbs.push(new StringBuilder());
        
        int k = 0;
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                k = (k * 10) + (c - '0');
            } else if (c == '[') {
                sbs.push(new StringBuilder());
                counts.push(k);
                k = 0;
            } else if (c == ']') {
                int j = counts.pop();
                StringBuilder curr = sbs.pop();
                StringBuilder prev = sbs.peek();
                for (int i = 0; i < j; i++) {
                    prev.append(curr);
                }
            } else {
                sbs.peek().append(c);
            }
        }
        
        return sbs.pop().toString();
    }
    
    
}