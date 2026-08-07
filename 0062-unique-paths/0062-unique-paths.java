class Solution {
    public int paths(int m, int n, int[][] dp) {
        if(n == 1 && m == 1) return 1;
        if(n == 0 || m == 0) return 0;

        if(dp[m][n] != -1) return dp[m][n];
        int rightWays = paths(m,n-1,dp);
        int downWays = paths(m-1,n,dp);
        
        return dp[m][n] = rightWays + downWays;
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];

        for(int i =0; i<=m ; i++){
            Arrays.fill(dp[i],-1);
        }

        return paths(m,n,dp);
    }
}