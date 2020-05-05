class Solution {
    public int firstUniqChar(String s) {
        int[] map = new int[123];
        
        int[] stack = new int[s.length()];
        int sSize = 0;
        
        for (int i = s.length() - 1; i >= 0; i--) {
            int code = (int)s.charAt(i);
            if (map[code] == 0) {
                stack[sSize++] = i;
            }
            map[code]++;
        }

        while (sSize > 0) {
            int index = stack[sSize - 1];
            if (map[s.charAt(index)] > 1) {
                sSize--;
            } else {
                return index;
            }
        }
        
        return -1;
    }
}