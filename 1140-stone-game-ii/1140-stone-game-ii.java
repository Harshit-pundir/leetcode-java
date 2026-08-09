class Solution {

    int[][] dp;
    int[] suffix;

    public int solve(int i, int M, int[] piles) {

        // Saare piles khatam
        if (i >= piles.length) {
            return 0;
        }

        // Already calculated
        if (dp[i][M] != -1) {
            return dp[i][M];
        }

        // Agar remaining saare piles le sakte hain
        if (2 * M >= piles.length - i) {
            return dp[i][M] = suffix[i];
        }

        int ans = 0;

        // Current player X piles le sakta hai
        for (int X = 1; X <= 2 * M && i + X <= piles.length; X++) {

            int newM = Math.max(M, X);

            // Opponent ke baad jo bachega,
            // wahi current player ka maximum hoga
            int current = suffix[i]
                    - solve(i + X, newM, piles);

            ans = Math.max(ans, current);
        }

        return dp[i][M] = ans;
    }

    public int stoneGameII(int[] piles) {

        int n = piles.length;

        dp = new int[n][n + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        // suffix sum
        suffix = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }

        return solve(0, 1, piles);
    }
}