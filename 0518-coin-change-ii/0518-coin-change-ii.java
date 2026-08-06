class Solution {
    public int solve(int idx, int amount, int[] coins, int[][] dp) {

        // Base case
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
        for (int[] row : dp)
            Arrays.fill(row, -1);

        return solve(n - 1, amount, coins, dp);
    }
}