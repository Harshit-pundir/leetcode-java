class Solution {
    public int solve(int idx , int[] nums,int[] dp){
        if(idx >= nums.length) return 0;
        if(dp[idx] != -1) return dp[idx];

        int notTake = solve(idx+1,nums,dp);
        int take = nums[idx] + solve(idx+2,nums,dp);
        
        return dp[idx] = Math.max(notTake,take);
    }
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return solve(0,nums,dp);
    }
}