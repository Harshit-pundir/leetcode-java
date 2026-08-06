class Solution {

    public boolean solve(int idx, String s, HashSet<String> set, int[] dp) {

        if (idx == s.length()) return true;

        if (dp[idx] != -1)
            return dp[idx] == 1;

        for (int i = idx; i < s.length(); i++) {

            String sub = s.substring(idx, i + 1);

            if (set.contains(sub)) {
                if (solve(i + 1, s, set, dp)) {
                    dp[idx] = 1;
                    return true;
                }
            }
        }

        dp[idx] = 0;
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {

         int n = s.length();

        HashSet<String> set = new HashSet<>(wordDict);

        boolean[] dp = new boolean[n + 1];

        dp[0] = true;

        for (int i = 1; i <= n; i++) {

            for (int j = 0; j < i; j++) {

                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}