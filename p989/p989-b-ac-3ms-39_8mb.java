class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
        
        List<Integer> list = new ArrayList<Integer>();
        for (int i = A.length - 1; i >= 0; i--) {
            list.add((A[i] + K) % 10);
            K = (A[i] + K) / 10;
        }
        
        while (K > 0) {
            list.add(K % 10);
            K = K / 10;
        }
        
        List<Integer> res = new ArrayList<>();
        
        for (int i = list.size() - 1; i >=0; i--) {
            res.add(list.get(i));
        }
        
        return res;
    }
}