class Solution {
    public int solve(int idx, int amount, int[] coins, int[][] dp) {

        if (idx == 0) {
            return (amount % coins[0] == 0) ? 1 : 0;
        }

        if (dp[idx][amount] != -1)
            return dp[idx][amount];

        int notTake = solve(idx - 1, amount, coins, dp);

        int take = 0;
        if (coins[idx] <= amount) {
            take = solve(idx, amount - coins[idx], coins, dp);
        }

        return dp[idx][amount] = take + notTake;
    }

    public int change(int amount, int[] coins) {
        int n = coins.length;

        int[][] dp = new int[n][amount + 1];

        // Base Case
        for (int target = 0; target <= amount; target++) {
            if (target % coins[0] == 0)
                dp[0][target] = 1;
        }

        for (int idx = 1; idx < n; idx++) {
            for (int target = 0; target <= amount; target++) {

                int notTake = dp[idx - 1][target];

                int take = 0;
                if (coins[idx] <= target) {
                    take = dp[idx][target - coins[idx]];
                }

                dp[idx][target] = take + notTake;
            }
        }

        return dp[n - 1][amount];
    }
}