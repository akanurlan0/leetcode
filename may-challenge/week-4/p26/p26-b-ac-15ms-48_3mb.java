class Solution {
    public int findMaxLength(int[] nums) {
        
        int res = 0;
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            
            sum += nums[i] == 0 ? -1 : 1;

            Integer firstMatch = map.get(sum);
            if (firstMatch == null) {
                map.put(sum, i);
            } else {
                if (i - firstMatch > res) {
                    res = i - firstMatch;
                }
            }
        }
        
        return res;
    }
}