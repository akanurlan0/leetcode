class Solution {
    public int twoCitySchedCost(int[][] costs) {
        
        Arrays.sort(costs, (int[] a, int[] b) -> {
            return (a[0] - a[1]) - (b[0] - b[1]);
        });
        
        int price = 0;
        for (int i = 0; i < costs.length / 2; i++) {
            price += costs[i][0] + costs[costs.length - i - 1][1];
        }
        
        return price;
    }
}