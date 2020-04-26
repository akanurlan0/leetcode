class Solution {
    public int[] sortArrayByParity(int[] a) {
        
        int n = a.length;
        
        int[] map = new int[5001];
        
        for (int i = 0; i < a.length; i++) {
            map[a[i]]++;
        }
        
        int counter = 0;
        
        for (int i = 0; i < 5001; i+=2) {

            for (int j = 0; j < map[i]; j++) {
                a[counter++] = i;
            }
        }
        
        for (int i = 1; i < 5001; i+=2) {

            for (int j = 0; j < map[i]; j++) {
                a[counter++] = i;
            }
        }
        
        return a;
    }
}