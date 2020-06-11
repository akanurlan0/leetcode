class Solution {
    public int[][] reconstructQueue(int[][] people) {
        
        Arrays.sort(people, (int[] o1, int[] o2) -> {
            int diff = o1[0] - o2[0];
            if (diff != 0) return diff;
            
            return o2[1] - o1[1]; 
        });
        
        int n = people.length;
        
        boolean[] busy = new boolean[n];
        int[][] res = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            int limit = people[i][1];
            int index = 0;
            while (limit > 0 || busy[index]) {
                if (busy[index]) {
                    index++;
                } else 
                if (limit > 0) {
                    index++;
                    limit--;
                }
            }
            
            busy[index] = true;
            res[index] = people[i];
        }
        
        return res;
    }
}