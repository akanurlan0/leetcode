import static java.lang.Math.max;

class Solution2 {

    public static void main(String[] args) {

        System.out.println(
            new Solution2().maxSubarraySumCircular(
                new int[] { -2,4,4,4,6 }
            )
        );
    }

    public int maxSubarraySumCircular(int[] A) {
        int n = A.length;

        int[] a = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            a[i] = A[i % n];
        }

        int[] dp = new int[2 * n];

        //base condition
        dp[0] = a[0];

        int answer = dp[0];

        for(int i = 1; i < 2 * n; i++) {
            dp[i] = Math.max(dp[i - 1], 0) + a[i];
            answer = Math.max(answer, dp[i]);
        }

        int m = Integer.MIN_VALUE;
        int index = -1;
        for (int i = n - 1; i < 2 * n - 1; i++) {
            if (index == -1 || m < dp[i]) {
                index = i;
                m = dp[i];
            }
        }

        int rem = (index % n) + 1;

        int max = Integer.MIN_VALUE;

        //base condition
        dp[0] = a[rem];

        answer = dp[0];

        for(int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], 0) + a[i + rem];
            answer = Math.max(answer, dp[i]);
        }

        return answer;
    }

//    public int maxSubarraySumCircular(int[] a) {
//
//        int n = a.length;
//
//        int max = 0;
//        int localMax = 0;
//
//        int lastDropped = 0;
//
//        for (int i = 0; i < 2*n; i++) {
//            localMax += a[i % n];
//            if (i >= n) {
//                if (i % n == lastDropped) {
//                    localMax -= a[lastDropped];
//                    lastDropped++;
//                }
//            }
//
//            if (localMax > max) {
//                max = localMax;
//            }
//
//            if (localMax < 0) {
//                localMax = 0;
//                lastDropped = i;
//            }
//        }
//
//        return max;
//    }
}