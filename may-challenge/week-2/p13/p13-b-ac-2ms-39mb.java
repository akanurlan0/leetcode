class Solution {
    public String removeKdigits(String num, int k) {
        
        StringBuilder sb = new StringBuilder(num);
        
        int start = -1;
        
        for (int j = 0; j < k; j++) {
            
            int index = start > -1 ? start : 0;
            for (int i = index; i < sb.length() - 1; i++) {
                if (sb.charAt(i) > sb.charAt(i+1)) {
                    index = i;
                    start = i-1;
                    break;
                }
                index = i + 1;
                start = i;
            }
            
            sb.deleteCharAt(index);
            if (start == sb.length() -1) {
                start--;
            }
        }
        
        if (sb.length() > 0) {
            while (sb.length() > 0 && sb.charAt(0) == '0') {
                sb.deleteCharAt(0);
            }
        }
        
        if (sb.length() == 0) {
            sb.append('0');
        }
        
        return sb.toString();
    }
}