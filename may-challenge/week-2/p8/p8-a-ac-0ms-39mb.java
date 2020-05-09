class Solution {
    public boolean checkStraightLine(int[][] crds) {
        double k, b;
        int i = 0;
        if (crds[i+1][0] - crds[i][0] > 0) {
            k = (double)(crds[i+1][1] - crds[i][1])/(crds[i+1][0] - crds[i][0]);
            b = (double)(-k * crds[i][0] + crds[i][1]);
            
            for (int j = 0; j < crds.length; j++) {
                double cy = k * crds[j][0] + b;
//                System.out.println(abs(cy - crds[j][1]));
                if (abs(cy - crds[j][1]) > 0.0001) {
                    return false;
                }
            }
        } else {
            k = (double)(crds[i+1][0] - crds[i][0])/(crds[i+1][1] - crds[i][1]);
            b = (double)(-k * crds[i][1] + crds[i][0]);
            
            for (int j = 0; j < crds.length; j++) {
                double cx = k * crds[j][1] + b;
//                System.out.println(abs(cx - crds[j][0]));
                if (abs(cx - crds[j][0]) > 0.0001) {
                    return false;
                }
            }
        }
        
        return true;
    }

    private double abs(double a) {
        if (a < 0) return -a;
        return a;
    }
}