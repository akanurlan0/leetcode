class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        int maxCount = 0;
        int value = 0;
        
        for (int i = 0; i < nums.length; i++) {
            int k = nums[i];
            int v = map.getOrDefault(k, 0) + 1;
            map.put(k, v);
            if (v > maxCount) {
                value = k;
                maxCount = v;
            }
        }
        
        return value;
    }
}