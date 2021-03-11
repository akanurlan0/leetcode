class Solution {
    public List<Integer> findDisappearedNumbers(int[] a) {
        
        int n = a.length;
        
        for (int i = 0; i < n; i++) {
            int k = Math.abs(a[i]) - 1;
            a[k] = -Math.abs(a[k]);
        }
        
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            if (a[i] > 0) {
                list.add(i+1);
            }
        }
        
        return list;
    }
}