class Solution {
    public int findMaxLength(int[] nums) {
        
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        
        int sum = 0;
        
        map.put(0, new ArrayList<Integer>());
        map.get(0).add(-1);
        
        for (int i = 0; i < nums.length; i++) {
            
            sum += nums[i] == 0 ? -1 : 1;
            
            final int iCopy = i;
            
            map.compute(sum, (k, v) -> {
                List<Integer> res = v;
                if (res == null) {
                    res = new ArrayList<Integer>();
                }
                res.add(iCopy);
                return res;
            });
        }
        
        int res = 0;
        
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            if (entry.getValue().size() == 1) continue;
            
            List<Integer> list = entry.getValue();
            
            int first = list.get(0);
            int last = list.get(list.size() - 1);
            
            if (last - first > res) {
                res = last - first;
            }
        }
        
        return res;
    }
}