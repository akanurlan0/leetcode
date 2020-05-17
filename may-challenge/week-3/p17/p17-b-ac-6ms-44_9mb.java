class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> res = new ArrayList<>();
        
        int[] pMap = new int[26];
        for (int i = 0; i < p.length(); i++) {
            pMap[p.charAt(i) - 'a']++;
        }
        
        int[] sMap = new int[26];
        for (int i = 0; i < s.length(); i++) {
            sMap[s.charAt(i) - 'a']++;
            
            if (i - p.length() >= 0) {
               sMap[s.charAt(i - p.length()) - 'a']--; 
            }
            
            boolean flag = true;
            for (int j = 0; j < 26; j++) {
                if (pMap[j] != sMap[j]) {
                    flag = false;
                    break;
                }
            }
            
            if (flag) {
                res.add(i - p.length() + 1);
            }
        }
        
        return res;
    }
}