class Solution {
    
    public int romanToInt(String s) {
        
        int result = 0;
        
        char[] c = s.toCharArray();
        
        int prev = 0;
        
        int i = 0;
        while (i < c.length) {
            int curr = toInteger(c[i++]);
            if (curr > prev) {
                result -= prev;
                curr -= prev;
            }
            result += curr;
            prev = curr;
        }
        
        return result;
    }
    
    private int toInteger(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default : throw new IllegalArgumentException();
        }
    }
}