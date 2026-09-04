class Solution {
    public int solve(int i , int j , int[][] obstacleGrid , int[][] dp){
        if(i == obstacleGrid.length-1 && j ==obstacleGrid[0].length-1 ) return 1;
        if(i >= obstacleGrid.length || j >= obstacleGrid[0].length || obstacleGrid[i][j] == 1) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int right = solve(i,j+1,obstacleGrid,dp);
        int down = solve(i+1,j,obstacleGrid,dp);

        return dp[i][j] = right + down;

    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        if(obstacleGrid[n-1][m-1] == 1) return 0; 
        int[][] dp = new int[n][m];
        for(int[] row : dp) Arrays.fill(row,-1);
        return solve(0,0,obstacleGrid,dp);
    }
}