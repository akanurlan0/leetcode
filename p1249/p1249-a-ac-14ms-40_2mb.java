class Solution {
    public String minRemoveToMakeValid(String s) {
        
        StringBuilder sb = new StringBuilder();
        
        Stack<Integer> stack = new Stack<Integer>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if ( c == '(') {
                stack.push(sb.length());
                sb.append(c);
            } 
            else if ( c == ')') {
                if (stack.empty() == false) {
                    sb.append(c);
                    stack.pop();
                }
            }
            else {
                sb.append(c);
            }
        }
        
        while (stack.empty() == false) {
            int pos = stack.pop();
            sb.deleteCharAt(pos);
        }
        
        return sb.toString();
    }
}