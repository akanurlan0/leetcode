class Solution {
    public boolean isValid(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        
        boolean good = true;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '(' || c == '{' || c == '[') {
                stack.push((int)c);
            } else {
                if (stack.empty()) {
                    good = false;
                    break;
                }
                int o = stack.pop();
                if (Math.abs(c - o) > 2) {
                    good = false;
                    break;
                }
            }
        }
        
        good = good && stack.empty();
        
        return good;
    }
}