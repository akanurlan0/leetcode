class Solution {
    public int totalFruit(int[] tree) {
        
        int n = tree.length;
        
        int max = 0;
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                set.add(tree[j]);
                if (set.size() <= 2) {
                    max = Math.max(max, j - i + 1);
                } else {
                    break;
                }
            }
            set.clear();
        }
        
        return max;
        
    }
}