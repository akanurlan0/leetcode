class Solution {
    public int[] dailyTemperatures(int[] T) {
        
        int[] res = new int[T.length];
        
        Stack<Integer> stack = new Stack<Integer>();
        
        for (int i = T.length - 1; i >= 0; i--) {
            
            int curr = T[i];
            
            while (!stack.empty() && T[stack.peek()] <= curr) {
                stack.pop();
            }
            
            if (stack.empty()) {
                res[i] = 0;
            } else {
                Integer found = stack.peek();
                res[i] = found - i;
            }
            
            stack.add(i);
        }
        
        return res;
    }
}