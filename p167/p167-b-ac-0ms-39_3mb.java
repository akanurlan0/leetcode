class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        
        while (true) {
            int a = numbers[l] + numbers[r];
            if (a > target) {
                r--;
            } else 
            if (a < target) {
                l++;
            } else {
                return new int[] {l+1, r+1};
            }
        }
    }
}