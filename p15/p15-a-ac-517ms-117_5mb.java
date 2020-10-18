class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);
        
        int n = nums.length;
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.compute(nums[i], (k, v) -> v == null ? 1 : v + 1);
        }
        
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (list.isEmpty()) {
                list.add(nums[i]);
            } else {
                if (list.get(list.size() - 1) != nums[i]) {
                    list.add(nums[i]);
                }
            }
        }
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        for (int i = 0; i < list.size(); i++) {
            int first = list.get(i);
            map.compute(first, (k, v) -> v - 1);
            
            for (int j = i; j < list.size(); j++) {
                int second = list.get(j);
                if (map.get(second) == 0) continue;
                
                map.compute(second, (k, v) -> v - 1);
                
                int third = 0 - (first + second);
                if (third >= second && map.containsKey(third) && map.get(third) > 0) {
                    result.add(Arrays.asList(first, second, third));
                }
                
                map.compute(second, (k, v) -> v + 1);
            }
            map.compute(first, (k, v) -> v + 1);
        }
        
        return result;
    }
}