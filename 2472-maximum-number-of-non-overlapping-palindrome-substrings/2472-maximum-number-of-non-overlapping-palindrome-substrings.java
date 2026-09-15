class Solution {

    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    int[] dp;

    public int solve(int idx, String s, int k) {

        if (idx >= s.length()) {
            return 0;
        }

        if (dp[idx] != -1) {
            return dp[idx];
        }

        
        int ans = solve(idx + 1, s, k);

        
        for (int j = idx + k - 1; j < s.length(); j++) {

            String sub = s.substring(idx, j + 1);

            if (isPalindrome(sub)) {
                ans = Math.max(ans, 1 + solve(j + 1, s, k));
                break; 
            }
        }

        return dp[idx] = ans;
    }

    public int maxPalindromes(String s, int k) {
        dp = new int[s.length()];
        Arrays.fill(dp, -1);

        return solve(0, s, k);
    }
}