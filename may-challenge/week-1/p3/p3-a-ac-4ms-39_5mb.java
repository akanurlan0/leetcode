class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] map = new int[123];
        for (int i = 0; i < magazine.length(); i++) {
            map[(int)magazine.charAt(i)]++;
        }
        
        for (int i = 0; i < ransomNote.length(); i++) {
            int code = (int)ransomNote.charAt(i);
            if (map[code] > 0) {
                map[code]--;
            } else {
                return false;
            }
        }
        
        return true;
    }
}