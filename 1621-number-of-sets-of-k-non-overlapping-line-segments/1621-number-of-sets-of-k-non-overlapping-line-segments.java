class Solution {

    static final int MOD = 1000000007;
    Long[][] dp;

    long combination(int n, int r) {
        
        if (r < 0 || r > n) {
            return 0;
        }
        if (r == 0 || r == n) {
            return 1;
        }
        if (dp[n][r] != null) {
            return dp[n][r];
        }
        
        long include = combination(n - 1, r - 1);
        long exclude = combination(n - 1, r);

        dp[n][r] = (include + exclude) % MOD;

        return dp[n][r];
    }
    public int numberOfSets(int n, int k) {
        dp = new Long[n + k][2 * k + 1];

        return (int) combination(n + k - 1, 2 * k);
    }

    
}