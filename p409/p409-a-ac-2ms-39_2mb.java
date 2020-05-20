class Solution {
    public int longestPalindrome(String s) {
        
        char[] c = s.toCharArray();
        
        int[] map = new int[255];
        for (int i = 0; i < c.length; i++) {
            map[c[i]]++;
        }
        
        int pairCount = 0;
        int oddPresent = 0;
        for (int i = 0; i < 255; i++) {
            pairCount += map[i] / 2;
            if ((map[i] & 1) == 1) {
                oddPresent = 1;
            }
        }
        
        return (pairCount * 2) + oddPresent;
    }
}