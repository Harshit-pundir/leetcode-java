class Solution {
    public int solve(int idx, int amount, int[] coins , int[][] dp){
        if(idx == 0){
            return (amount % coins[idx] == 0) ? 1 : 0;
        }
        if(dp[idx][amount] != -1) return dp[idx][amount];
        int notPick = solve(idx-1,amount,coins,dp);
        int pick = 0;
        if(coins[idx] <= amount) pick = solve(idx,amount-coins[idx],coins,dp);

        return dp[idx][amount] = notPick + pick;
    }
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        
        for(int sum =0; sum <= amount ; sum++){
            if(sum % coins[0] == 0) dp[0][sum] = 1;
        }
        for(int idx = 0; idx< n; idx++) dp[idx][0] = 1;
        
        for(int idx = 1; idx < n; idx++){
            for(int sum =0; sum <= amount; sum++){
                int notPick = dp[idx-1][sum];
                int pick = 0;
                if (coins[idx] <= sum)
                    pick = dp[idx][sum - coins[idx]];
                
                dp[idx][sum] = pick + notPick;
            }
        }
        
        return dp[n-1][amount];
    }
}