class Solution {
    
    public int maxSubarraySumCircular(int[] A) {
        int n = A.length;
        int[] dp = new int[n];

        int[] a = new int[n];

        int max = Integer.MIN_VALUE;

        for (int j = 0; j < n; j++) {

            for (int i = 0; i < n; i++) {
                int k = (i + j) % n;
                a[i] = A[k];
            }

            //base condition
            dp[0] = a[0];

            int answer = dp[0];

            for(int i = 1; i < n; i++) {
                dp[i] = Math.max(dp[i - 1], 0) + a[i];
                answer = Math.max(answer, dp[i]);
            }

            if (max == Integer.MIN_VALUE || answer > max) {
                max = answer;
            }
        }

        return max;
    }
}