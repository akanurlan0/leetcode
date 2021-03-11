class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        
        Stack<Integer> stack = new Stack<>();

        int i = 0;
        int j = 0;
        int n = pushed.length;
        
        while (j < n) {
            if (!stack.empty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            } else {
                if (i == n) break;
                stack.push(pushed[i++]);
            }
        }
        
        if (j < n) return false;
        return true;
    }
}