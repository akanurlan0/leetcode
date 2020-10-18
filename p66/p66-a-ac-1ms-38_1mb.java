class Solution {
    public int[] plusOne(int[] digits) {
        Stack<Integer> stack = new Stack<>();
        int leftover = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = leftover + digits[i];
            stack.push(sum % 10);
            leftover = sum / 10;
        }
        if (leftover > 0) {
            stack.push(leftover);
        }
        
        int[] res = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            res[i++] = stack.pop();
        }
        
        return res;
    }
}