class Solution {
    public int numJewelsInStones(String J, String S) {
        boolean[] map = new boolean[123];
        
        for (int i = 0; i < J.length(); i++) {
            map[(int)J.charAt(i)] = true;
        }
        
        int res = 0;
        
        for (int i = 0; i < S.length(); i++) {
            if (map[(int)S.charAt(i)]) res++;
        }
        
        return res;
    }
}