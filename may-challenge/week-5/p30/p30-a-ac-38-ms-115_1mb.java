class Solution {
    public int[][] kClosest(int[][] points, int K) {
        
        PriorityQueue<Point> pq = new PriorityQueue<Point>(K, (o1, o2) -> {
            return Double.compare(o1.radius, o2.radius);
        });
        for (int i = 0; i < points.length; i++) {
            pq.add(
                new Point(
                    Math.sqrt(
                        Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2) 
                    ) 
                    , i
                )
            );
        }
        
        int[][] res = new int[K][2];
        for (int i = 0; i < K; i++) {
            Point p = pq.poll();
            res[i][0] = points[p.index][0];
            res[i][1] = points[p.index][1];
        }
        
        return res;
    }
    
    class Point {
        public double radius;
        public int index;
        
        public Point(double radius, int index) {
            this.radius = radius;
            this.index = index;
        }
    }
}