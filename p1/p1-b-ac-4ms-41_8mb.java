class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            List<Integer> v = map.getOrDefault(n, new ArrayList<Integer>());
            v.add(i);
            map.put(n, v);
        }
        
        for (int i = 0; i < nums.length; i++) {
            int r = target - nums[i];
            
            if (map.containsKey(r) == false) continue;
            
            List<Integer> v = map.get(r);
            
            int j = 0;
            while (j < v.size() && v.get(j) == i) j++;
            
            if (j == v.size()) continue;
            
            return new int[] {i, v.get(j)};
        }
        
        throw new IllegalStateException();
    }
}