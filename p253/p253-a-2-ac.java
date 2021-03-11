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
        
        int i = 0;
        int j = 0;
        
        int max = 0;
        int counter = 0;
        
        while (i < n) {
            if (s[i] < e[j]) {
                i++;
                counter++;
                max = Math.max(max, counter);
            } 
            else {
                j++;
                counter--;
            }
        }
        
        return max;
    }
}