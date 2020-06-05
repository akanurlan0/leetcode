class Solution {
    public int twoCitySchedCost(int[][] costs) {
        
        int n = costs.length;
        
        List<Pair> list = new ArrayList<Pair>();
        for (int i = 0; i < n; i++) {
            int diff = costs[i][0] - costs[i][1];
            list.add(new Pair(diff, i));
        }
        
        Collections.sort(list, (o1, o2) -> {
            return Integer.compare(o1.diff, o2.diff);
        });
        
        int price = 0;
        for (int i = 0; i < n; i++) {
            int index = list.get(i).index;
            if (i < (n/2)) {
                price += costs[index][0];
            } else {
                price += costs[index][1];
            }
        }
        
        return price;
    }
    
    class Pair {
        public final int diff, index;
        
        public Pair(int diff, int index) {
            this.diff = diff;
            this.index = index;
        }
    }
}