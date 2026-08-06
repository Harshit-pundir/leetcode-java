class Solution {

    public int solve(int idx, int end, int[] nums, int[] dp) {

        if (idx > end)
            return 0;

        if (dp[idx] != -1)
            return dp[idx];

        int notTake = solve(idx + 1, end, nums, dp);
        int take = nums[idx] + solve(idx + 2, end, nums, dp);

        return dp[idx] = Math.max(take, notTake);
    }

    public int rob(int[] nums) {

        int n = nums.length;

        if (n == 1)
            return nums[0];

        // Case 1 : Rob from 0 to n-2
        int[] dp1 = new int[n];
        Arrays.fill(dp1, -1);
        int case1 = solve(0, n - 2, nums, dp1);

        // Case 2 : Rob from 1 to n-1
        int[] dp2 = new int[n];
        Arrays.fill(dp2, -1);
        int case2 = solve(1, n - 1, nums, dp2);

        return Math.max(case1, case2);
    }
}