class Solution {
    public String licenseKeyFormatting(String s, int k) {
        
        int counter = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '-') continue;
            sb.append(Character.toUpperCase(c));
            if (++counter == k) {
                sb.append('-');
                counter = 0;
            }
        }
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '-') {
            sb.setLength(sb.length() - 1);
        }
        return sb.reverse().toString();
    }
}