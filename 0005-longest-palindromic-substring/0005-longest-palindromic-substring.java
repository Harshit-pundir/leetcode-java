class Solution {
    public boolean isPalindrome(int i, int j, String s) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;

            i++;
            j--;
        }
        return true;
    }
    public String solveMem(int i, int j, String s, String[][] dp) {

        // Base cases
        if (i > j)
            return "";

        if (i == j)
            return s.substring(i, i + 1);

        // Already calculated
        if (dp[i][j] != null)
            return dp[i][j];

        // Current substring is palindrome
        if (isPalindrome(i, j, s)) {
            return dp[i][j] = s.substring(i, j + 1);
        }

        // Exclude left character
        String left = solveMem(i + 1, j, s, dp);

        // Exclude right character
        String right = solveMem(i, j - 1, s, dp);

        // Store longer answer
        if (left.length() >= right.length())
            dp[i][j] = left;
        else
            dp[i][j] = right;

        return dp[i][j];
    }

    public String longestPalindrome(String s) {
        int n = s.length();
        String[][] dp = new String[n][n];
        return solveMem(0, n - 1, s, dp);
    }

    
}