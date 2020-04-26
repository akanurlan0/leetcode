class Solution {
    public int[] countBits(int num) {
        
        int[] c = new int[num+1];
        
        boolean odd = false;
            
        for (int i = 0; i <= num; i++) {
            c[i] += odd? 1 : 0; 
            c[i] += c[i / 2];
            
            odd = !odd;
        }
    
        return c;
    }
}