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

        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        HashSet<String> set = new HashSet<>(wordDict);

        return solve(0, s, set, dp);
    }
}