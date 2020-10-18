class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        
        int[] stack = new int[n];
        int p = 0;
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack[p++] = -2;
            } 
            else if (c == ')') {
                int plus = 0;
                boolean ok = false;
                while (p > 0) {
                    int el = stack[p - 1];
                    if (el > 0) {
                        plus += el;
                        p--;
                    }
                    else if (el == -2) {
                        plus++;
                        p--;
                        ok = true;
                        break;
                    }
                    else {
                        ok = false;
                        break;
                    }
                }
                if (plus > 0) {
                    stack[p++] = plus;
                }
                if (!ok) {
                    stack[p++] = -1;
                }
            }
        }
        
        int result = 0;
        int localMax = 0;
        while (p > 0) {
            int el = stack[p - 1]; 
            p--;
            if (el > 0) {
                localMax += (2 * el);
            } else {
                localMax = 0;
            }
            result = Math.max(result ,localMax);
        }
        
        return result;
    }
}