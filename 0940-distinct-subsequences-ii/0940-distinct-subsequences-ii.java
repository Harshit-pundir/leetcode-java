class Solution {
    int[] dp;
    int[] last;
    int MOD = 1000000007;

    public int solve(int idx, String s) {
        if (idx == s.length()) {
            return 1; // empty subsequence
        }

        if (dp[idx] != -1) {
            return dp[idx];
        }

        char c = s.charAt(idx);

        long ans = 2L * solve(idx + 1, s);

        if (last[c - 'a'] != -1) {
            ans -= solve(last[c - 'a'] + 1, s);
        }

        last[c - 'a'] = idx;

        return dp[idx] = (int)(ans % MOD);
    }

    public int distinctSubseqII(String s) {
        int n = s.length();

        dp = new int[n];
        Arrays.fill(dp, -1);

        last = new int[26];
        Arrays.fill(last, -1);

        return (solve(0, s) - 1 + MOD) % MOD;
    }
}