class Solution {
    public int minimumChanges(String s, int k) {
        int n = s.length();
        int[][] cost = new int[n][n];

        // Step 1: Precompute cost for every substring
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len <= n; i++) {
                int j = i + len - 1;
                cost[i][j] = Integer.MAX_VALUE;

                // Try every proper divisor
                for (int d = 1; d < len; d++) {
                    if (len % d != 0) continue;

                    int changes = 0;

                    // Check each group
                    for (int r = 0; r < d; r++) {
                        int count = (len - 1 - r) / d + 1;

                        // Check palindrome pairs
                        for (int x = 0; x < count / 2; x++) {
                            int left = i + r + x * d;
                            int right = i + r + (count - 1 - x) * d;

                            if (s.charAt(left) != s.charAt(right)) {
                                changes++;
                            }
                        }
                    }

                    cost[i][j] = Math.min(cost[i][j], changes);
                }
            }
        }

        // Step 2: DP
        int INF = 1000000;
        int[][] dp = new int[k + 1][n + 1];

        for (int[] row : dp) {
            Arrays.fill(row, INF);
        }

        dp[0][0] = 0;

        // i = number of characters considered
        // p = number of partitions
        for (int p = 1; p <= k; p++) {
            for (int i = 2 * p; i <= n; i++) {

                // Try every possible starting point of last substring
                for (int start = 2 * (p - 1); start <= i - 2; start++) {

                    dp[p][i] = Math.min(
                        dp[p][i],
                        dp[p - 1][start] + cost[start][i - 1]
                    );
                }
            }
        }

        return dp[k][n];
    }
}