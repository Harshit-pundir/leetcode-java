class Solution {
    public int solve(int i, int n, int count, int[][] dp) {
        if (n == 0) return count >= 2 ? 1 : 0;
        if (n < 0 || i > n) return 0;

        if(dp[i][n] != -1) return dp[i][n];
        int take = 0;
        if (i <= n) {
            int res = solve(i, n - i, count + 1,dp);
            if (res > 0) take = i * res;
        }

        int notTake = solve(i + 1, n, count,dp);

        return dp[i][n] = Math.max(take, notTake);
    }

    public int integerBreak(int n) {
        int[][] dp = new int[n+1][n+1];
        for(int[] arr : dp) Arrays.fill(arr,-1);
        return solve(1, n, 0,dp);
    }
}