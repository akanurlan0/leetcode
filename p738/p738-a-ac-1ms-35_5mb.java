class Solution {
    public int monotoneIncreasingDigits(int n) {

        while (true) {
            
            int d = n;
            int step = 0;
            
            boolean flag = true;
            
            while (d > 0) {
                int r = d % 10;
                d = d / 10;
                int f = d % 10;
                
                step++;
                
                if (r < f) {
                    d -= 1;
                    while (step > 0) {
                        d = (d * 10) + 9;
                        step--;
                    }
                    n = d;
                    flag = false;
                    break;
                }
            }
            if (flag) break;
        }
        
        return n;
    }
}