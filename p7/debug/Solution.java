package debug;

class Solution {

    public static void main(String[] args) {
        new Solution().reverse(-123);
    }

    public int reverse(int x) { // -123
        
        StringBuilder sb = new StringBuilder();
        
        int a = Math.abs(x); // 123
        int r = 0;           // 0
        while (a > 9) { // true
            r = a % 10; // r = 2
            a = a / 10; // a = 1
            
            sb.append((char)(r + '0')); // sb: '32'
        }
        sb.append((char)(a + '0')); // sb: '321'
        
        String reversed = sb.toString(); // reversed: '321'

        int border  = Math.abs( (x < 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE) / 10 ); // border: (2^31 - 1) / 10
        int rem     = Math.abs( (x < 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE) % 10 ) ; // 2
        
        int result = 0;
        
        for (char c : reversed.toCharArray()) {
            
            int digit = c - '0'; // 3
            
            if (result > border) {
                return 0;
            }
            else if (result == border && digit > rem) {
                return 0;
            } else {
                result = (result * 10) + digit;
            }
        }
        
        if (x < 0) {
            result = -result;
        }
        
        return result;
    }
}