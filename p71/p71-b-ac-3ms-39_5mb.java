class Solution {
    public String simplifyPath(String path) {
        
        // split
        String[] paths = path.split("/");
        
        Deque<String> stack = new LinkedList<>();
        
        for (int i = 0; i < paths.length; i++) {
            
            if (paths[i].equals("") || paths[i].equals(".")) {
                continue;
            }
            
            if (paths[i].equals("..")) {
                if (stack.size() > 0) {
                    stack.pop();
                }
                continue;
            }
            
            stack.push(paths[i]);
        }
        
        StringBuilder sb = new StringBuilder();
        
        if (stack.size() == 0) {
            sb.append("/");
        }
        while (stack.size() > 0) {
            sb.append("/");
            sb.append(stack.pollLast());
        }
        
        return sb.toString();
    }
}