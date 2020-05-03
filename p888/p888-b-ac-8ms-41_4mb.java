class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        
        int s1 = 0;
        for (int i = 0; i < A.length; i++) {
            s1 += A[i];
        }
        
        int s2 = 0;
        for (int i = 0; i < B.length; i++) {
            s2 += B[i];
        }
        
        int s = (s1 + s2) / 2;
        
        HashSet<Integer> comp = new HashSet<Integer>();
        for (int i = 0; i < B.length; i++) {
            comp.add(B[i]);
        }
        
        for (int i = 0; i < A.length; i++) {
            int remaining = s1 - A[i];
            if (comp.contains(s - remaining)) {
                return new int[] { A[i], s - remaining };
            }
        }
        
        return null;
    }
}