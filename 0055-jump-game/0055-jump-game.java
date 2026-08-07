class Solution {
    public boolean solve(int idx , int[] nums , int[] dp){
        if(idx >= nums.length-1) return true;
        if(nums[idx] == 0 ) return false;

        if(dp[idx] != -1) return (dp[idx] == 0) ? false : true;

        for(int jump = 1; jump <= nums[idx] ; jump++){
            if(solve(idx + jump , nums,dp)) {
                dp[idx] = 1;
                return true;
            }
        }
        dp[idx] = 0;
        return false;
    }
    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return solve(0,nums,dp);
    }
}