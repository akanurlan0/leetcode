class Solution {

    private int[][] intervals;
    private int[] indexes;
    private Map<Integer, int[]> map;

    public int[][] merge(int[][] intervals_) {

        intervals = intervals_;

        int n = intervals.length;
        
        Arrays.sort(intervals, (int[] o1, int[] o2) -> Integer.compare(o1[0], o2[0]));
        
        indexes = new int[n];
        for (int i = 0; i < n; i++) {
            indexes[i] = i;
        }

        map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(indexes[i], intervals[i]);
        }

        mergeInternal(0, n - 1);

        int[][] result = new int[map.size()][2];
        
        int c = 0;
        for (int[] arr : map.values()) {
            result[c][0] = arr[0];
            result[c][1] = arr[1];
            c++;
        }
        
        return result;
    }
    
    private void mergeInternal(int l, int r) {
        
        if (l >= r) return;
        
        int m = l + ( (r - l) / 2 );
        
        mergeInternal(l, m);
        mergeInternal(m + 1, r);
        
        int x = m;

        int[] a = map.get(indexes[x]);
        for (int y = m + 1; y <= r; y++) {
            if (!map.containsKey(indexes[y])) continue;
            if (indexes[x] == indexes[y]) continue;
            int[] b = map.get(indexes[y]);

            if (a[1] >= b[0]) {

                int indexToRemove = indexes[y];

                for (int i = 0; i < indexes.length; i++) {
                    if (indexes[i] == indexToRemove) {
                        indexes[i] = indexes[x];
                    }
                }

                a[0] = Math.min(a[0], b[0]);
                a[1] = Math.max(a[1], b[1]);

                map.remove(indexToRemove);
            }
        }
    }
}