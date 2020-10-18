class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        
        Stack<Integer> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(-2);
            } 
            else if (c == ')') {
                int plus = 0;
                boolean ok = false;
                while (!stack.isEmpty()) {
                    int p = stack.peek();
                    if (p > 0) {
                        plus += p;
                        stack.pop();
                    } 
                    else if (p == -2) {
                        stack.pop();
                        plus++;
                        ok = true;
                        break;
                    }
                    else {
                        ok = false;
                        break;
                    }
                }
                if (plus > 0) {
                    stack.push(plus);
                }
                if (!ok) {
                    stack.push(-1);
                }
            }
        }
        
        int result = 0;
        int localMax = 0;
        while (stack.isEmpty() == false) {
            int p = stack.pop();
            if (p > 0) {
                localMax += (2 * p);
            } else {
                localMax = 0;
            }
            result = Math.max(result ,localMax);
        }
        
        return result;
    }
}