class Solution {
    public String simplifyPath(String path) {
        // cleanup path
        path = path.replace("/{2,}", "/");
        
        // split
        String[] paths = path.split("/");
        
        Stack<String> stack = new Stack<>();
        
        for (int i = 0; i < paths.length; i++) {
            
            if (paths[i].equals("")) {
                continue;
            }
            
            if (paths[i].equals(".")) {
                continue;
            }
            
            if (paths[i].equals("..")) {
                if (stack.empty() == false) {
                    stack.pop();
                }
                continue;
            }
            
            stack.push(paths[i]);
        }
        
        Stack<String> reverse = new Stack<>();
        while (stack.empty() == false) {
            reverse.push(stack.pop());
        }
        
        StringBuilder sb = new StringBuilder();
        
        if (reverse.empty()) {
            sb.append("/");
        }
        while (reverse.empty() == false) {
            sb.append("/");
            sb.append(reverse.pop());
        }
        
        return sb.toString();
    }
}