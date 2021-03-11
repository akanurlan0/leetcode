class Solution {

    public int[][] merge(int[][] intervals) {

        int n = intervals.length;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        List<int[]> list = new ArrayList<>();
        int i = 0;
        int[] prev = null;
        while (i < n) {
            
            int[] curr = intervals[i];
            
            if (prev == null) {
                prev = curr;
                i++;
                continue;
            }
            
            if (prev[1] >= curr[0]) {
                prev[1] = Math.max(prev[1], curr[1]);
                i++;
                continue;
            }
            
            list.add(prev);
            prev = null;
        }
        
        if (prev != null) {
            list.add(prev);
        }
        
        int[][] res = new int[list.size()][2];
        for (int j = 0; j < res.length; j++) {
            res[j] = list.get(j);
        }
        
        return res;
    }
}