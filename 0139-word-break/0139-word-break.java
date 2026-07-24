class Solution {
    public boolean solve(int idx, String s, HashSet<String> set, Boolean[] dp) {

        if (idx == s.length())
            return true;

        if (dp[idx] != null)
            return dp[idx];

        for (int i = idx; i < s.length(); i++) {

            String word = s.substring(idx, i + 1);

            if (set.contains(word)) {

                if (solve(i + 1, s, set, dp)) {
                    dp[idx] = true;   // Store true
                    return true;
                }
            }
        }

        dp[idx] = false;
        return false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {

        Set<String> set = new HashSet<>(wordDict);

        int n = s.length();

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