class Solution {
    public boolean increasingTriplet(int[] nums) {
        
        Integer first = null;
        Integer second = null;
        
        for (int n : nums) {
            if (first == null) {
                first = n;
                continue;
            }
            if (second == null) {
                if (first >= n) {
                    first = n;
                } else {
                    second = n;
                }
            } else {
                if (second < n) return true;
            }
        }
        
        return false;
    }
}