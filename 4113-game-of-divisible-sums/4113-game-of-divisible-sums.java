class Solution {
    public long maxDifference(int[] nums) {
        int n = nums.length;
        long[] dp = new long[n + 2];

        for (int i = n - 1; i >= 0; i--) {

            long one = nums[i];
            long takeOne;

            if (one % 3 == 0) {
                takeOne = one - dp[i + 1];
            } else {
                takeOne = one + dp[i + 1];
            }

            long takeTwo = Long.MIN_VALUE;

            if (i + 1 < n) {
                long two = nums[i] + nums[i + 1];

                if (two % 3 == 0) {
                    takeTwo = two - dp[i + 2];
                } else {
                    takeTwo = two + dp[i + 2];
                }
            }

            dp[i] = Math.max(takeOne, takeTwo);
        }

        return dp[0];
    }
}
