class Solution {

    int[] dp;

    public int solve(int n) {

        if (n == 0) {
            return 0;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        int ans = Integer.MAX_VALUE;

        int points = 0;

        for (int streak = 1; ; streak++) {

            points += streak;

            if (points > n) {
                break;
            }

            int remaining = n - points;

            int days = streak;

            if (remaining > 0) {
                // One skip before starting next streak
                days += 1;
            }

            days += solve(remaining);

            ans = Math.min(ans, days);
        }

        return dp[n] = ans;
    }

    public int minDays(int n) {

        dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return solve(n);
    }
}