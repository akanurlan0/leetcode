class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push('(');
            } 
            else if (c == ')') {
                if (stack.isEmpty()) {
                    stack.push(')');
                    continue;
                }
                int plus = 0;
                boolean ok = false;
                while (!stack.isEmpty()) {
                    char p = stack.peek();
                    if (p == '+') {
                        plus++;
                        stack.pop();
                    } 
                    else if (p == '(') {
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
                for (int i = 0; i < plus; i++) {
                    stack.push('+');
                }
                if (!ok) {
                    stack.push(')');
                }
            }
        }
        
        int result = 0;
        int localMax = 0;
        while (stack.isEmpty() == false) {
            if (stack.pop() == '+') {
                localMax += 2;
            } else {
                localMax = 0;
            }
            result = Math.max(result ,localMax);
        }
        
        return result;
    }
}