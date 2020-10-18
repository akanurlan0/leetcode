class Solution {
    public int[] dailyTemperatures(int[] T) {
        
        int[] res = new int[T.length];
        
        Stack<Node> stack = new Stack<Node>();
        
        for (int i = T.length - 1; i >= 0; i--) {
            
            int curr = T[i];
            
            while (!stack.empty() && stack.peek().val <= curr) {
                stack.pop();
            }
            
            if (stack.empty()) {
                res[i] = 0;
            } else {
                Node found = stack.peek();
                res[i] = found.pos - i;
            }
            
            stack.add(new Node(T[i], i));
        }
        
        return res;
    }
    
    class Node {
        int val;
        int pos;
        
        Node(int v, int p) {
            val = v;
            pos = p;
        }
    }
}