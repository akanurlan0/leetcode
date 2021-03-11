class Solution {
    public int kEmptySlots(int[] bulbs, int k) {
        
        int n = bulbs.length;
        
        boolean[] map = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            map[bulbs[i] - 1] = true;
            
            int prev = -1;
            
            for (int j = 0; j < n; j++) {
                if (map[j]) {
                    if (prev == -1) {
                        prev = j;
                    } else {
                        if (j - prev - 1 == k) return i + 1;
                        prev = j;
                    }
                }
            }
        }
        
        return -1;
    }
}