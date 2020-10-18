class Solution {
    public String longestCommonPrefix(String[] strs) {

        boolean good = strs.length > 0;
        int right = 0;
        while (good) {
            Character c = null;
            for (int i = 0; i < strs.length; i++) {
                if (right == strs[i].length()) {
                    good = false;
                    break;
                }
                if (c == null) {
                    c = strs[i].charAt(right);
                    continue;
                }
                if (c != strs[i].charAt(right)) {
                    good = false;
                    break;
                }
            }
            if (good) {
                right++;
            }
        }
        
        if (right == 0) {
            return "";
        }
        
        return strs[0].substring(0, right);
    }
}