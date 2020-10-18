class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> result = new ArrayList<>();

        int len = 0;
        List<Integer> prev = null;
        for (int i = 0; i < n; i++) {
            List<Integer> curr = new ArrayList<>();
            curr.add(1);
            int j = 1;
            while (j < len) {
                int val = prev.get(j - 1) + prev.get(j);
                curr.add(val);
                j++;
            }
            if (len > 0) curr.add(1);
            len++;
            
            result.add(curr);
            prev = curr;
        }
        
        return result;
    }
}