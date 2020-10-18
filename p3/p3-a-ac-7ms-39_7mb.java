class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        
        Set<Character> present = new HashSet<>();
        
        int l = 0;
        int r = 0;
        
        char[] arr = s.toCharArray();
        
        for (char c : arr) {
            while (present.contains(c)) {
                present.remove(arr[l]);
                l++;
            }
            r++;
            present.add(c);
            
            max = Math.max(max, r - l);
        }
        
        return max;
    }
}