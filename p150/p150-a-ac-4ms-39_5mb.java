class Solution {
    public int evalRPN(String[] tokens) {
        
        Stack<Integer> stack = new Stack<Integer>();
        
        for (String curr : tokens) {
            if      (curr.equals("+")) {
                int arg2 = stack.pop();
                int arg1 = stack.pop();
                stack.push(arg1 + arg2);
            } 
            else if (curr.equals("-")) {
                int arg2 = stack.pop();
                int arg1 = stack.pop();
                stack.push(arg1 - arg2);
            }
            else if (curr.equals("*")) {
                int arg2 = stack.pop();
                int arg1 = stack.pop();
                stack.push(arg1 * arg2);
            }
            else if (curr.equals("/")) {
                int arg2 = stack.pop();
                int arg1 = stack.pop();
                stack.push(arg1 / arg2);
            } else {
                stack.push(Integer.parseInt(curr));
            }
        }
        
        return stack.pop();
    }
}