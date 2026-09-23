class Solution {
    int[][] dp;
    int solve(int i, int j, int[] nums1, int[] nums2) {

        if (i >= nums1.length || j >= nums2.length) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (nums1[i] == nums2[j]) {
            dp[i][j] = 1 + solve(i + 1, j + 1, nums1, nums2);
        } else {
            dp[i][j] = 0;
        }

        return dp[i][j];
    }
    public int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans = Math.max(ans, solve(i, j, nums1, nums2));
            }
        }

        return ans;
    }

    
}