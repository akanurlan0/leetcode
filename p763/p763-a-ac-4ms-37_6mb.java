class Solution {
    public List<Integer> partitionLabels(String s) {
                
        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int code = s.charAt(i) - 'a';
            map[code] = Math.max(map[code], i);
        }
        
        List<Integer> list = new ArrayList<>();
        
        int l = 0;
        int r = 0;
        
        int i = 0;
        while (i < s.length()) {
            int code = s.charAt(i) - 'a';
            r = Math.max(r, map[code]);
            if (i == r) {
                list.add(r - l + 1);
                l = i + 1;
            }
            i++;
        }
        
        return list;
    }
}