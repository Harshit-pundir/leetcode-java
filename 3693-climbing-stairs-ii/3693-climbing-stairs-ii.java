class Solution {
    public int solve(int step, int n, int[] costs,int[] dp) {

        if (step == n) return 0;
        if(dp[step] != -1) return dp[step];

        int first = Integer.MAX_VALUE;

        if (step + 1 <= n) {
           first = costs[step] + 1 + solve(step + 1, n, costs,dp);
        }

        int second = Integer.MAX_VALUE;;
        if (step + 2 <= n) {
            second = costs[step + 1] + 4 + solve(step + 2, n, costs,dp);
        }

        int third = Integer.MAX_VALUE;;
        if (step + 3 <= n) {
            third = costs[step + 2] + 9 + solve(step + 3, n, costs,dp);
        }

        return dp[step] = Math.min(first,Math.min(second,third));
    }

    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return solve(0, n, costs,dp);
    }
}