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
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] += dp[j - coin];
            }
        }
        return dp[amount];
    }
}