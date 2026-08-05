class Solution {
    public int solve(int step, int n, int[] dp) {
        if (step == n) return 1;

        if (dp[step] != -1) return dp[step];

        int take_one = 0;
        if (step + 1 <= n)
            take_one = solve(step + 1, n, dp);

        int take_two = 0;
        if (step + 2 <= n)
            take_two = solve(step + 2, n, dp);

        return dp[step] = take_one + take_two;
    }

    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return solve(0, n, dp);
    }
}