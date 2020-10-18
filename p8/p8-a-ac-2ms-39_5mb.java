class Solution {
    public int myAtoi(String str) {
        StringBuilder sb = new StringBuilder();
        
        int signFactor = 1;
        boolean digitStarted = false;
        for (char c : str.toCharArray()) {
            if (c == '-' && !digitStarted) {
                digitStarted = true;
                signFactor = -1;
            } else if (c == '+' && !digitStarted) {
                digitStarted = true;
                signFactor = 1;
            } else if ('0' <= c && c <= '9') {
                digitStarted = true;
                sb.append(c);
            } else if (Character.isWhitespace(c) && !digitStarted) { 
                continue;
            } else {
                break;
            }
        }
        
        int border = signFactor > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        int div = Math.abs(border / 10);
        int rem = Math.abs(border % 10);
        
        int result = 0;
        for (char c : sb.toString().toCharArray()) {
            int digit = c - '0';
            
            if (div < result) {
                return border;
            } else if (div == result) {
                if (rem <= digit) {
                    return border;
                }
            }
            
            result = (result * 10) + digit;
        }
        
        result *= signFactor;
        
        return result;
    }
}