class Solution {
    public String simplifyPath(String path) {
        
        // split
        String[] paths = path.split("/");
        
        Stack<String> stack = new Stack<>();
        
        for (int i = 0; i < paths.length; i++) {
            
            if (paths[i].equals("") || paths[i].equals(".")) {
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
        
        String res = "";
        
        while (stack.empty() == false) {
            res = "/" + stack.pop() + res;
        }
        
        if (res.length() == 0) res = "/";
        
        return res;
    }
}