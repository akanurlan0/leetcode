class Solution {
    public int minMeetingRooms(int[][] intervals) {
        
        int n = intervals.length;
        
        int[] s = new int[n];
        int[] e = new int[n];
        
        for (int k = 0; k < n; k++) {
            int[] i = intervals[k];
            s[k] = i[0];
            e[k] = i[1];
        }
        
        Arrays.sort(s);
        Arrays.sort(e);
        
        int j = 0;
        int max = 0;
        
        for (int i = 0; i < n; i++) {
            if (s[i] < e[j]) {
                max++;
            } else {
                j++;
            }
        }
        
        return max;
    }
}