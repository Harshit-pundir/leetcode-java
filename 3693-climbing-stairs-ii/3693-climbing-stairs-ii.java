class Solution {
    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[n + 1];
        for (int step = n - 1; step >= 0; step--) {

            int first = Integer.MAX_VALUE;
            int second = Integer.MAX_VALUE;
            int third = Integer.MAX_VALUE;

            if (step + 1 <= n) {
                first = costs[step] + 1 + dp[step + 1];
            }

            if (step + 2 <= n) {
                second = costs[step + 1] + 4 + dp[step + 2];
            }

            if (step + 3 <= n) {
                third = costs[step + 2] + 9 + dp[step + 3];
            }

            dp[step] = Math.min(first, Math.min(second, third));
        }

        return dp[0];
    }
}