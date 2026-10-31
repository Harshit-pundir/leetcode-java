class Solution {
    int MOD = 1_000_000_007;
    public int uniquePaths(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][][] dp = new int[n][m][2];

        for(int[][]  rows : dp){
            for(int[] row : rows){
                Arrays.fill(row,-1);
            }
        }

        return dfs(grid,0,0,1,dp);
    }

    public int dfs(int[][] grid , int i , int j, int direction , int[][][] dp){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return 0;

        if(i == grid.length-1 && j == grid[0].length-1) return 1;
        if(dp[i][j][direction] !=-1) return dp[i][j][direction];

        int result = 0;
        if(grid[i][j] == 1){
            if(direction == 1){
                result = dfs(grid,i+1, j , 0, dp);
            }else{
                result = dfs(grid,i, j + 1, 1, dp);
            }
        }else{
            result = (dfs(grid,i+1,j,0,dp)%MOD + dfs(grid,i,j+1,1,dp)%MOD)%MOD;
        }

        return dp[i][j][direction] = result;
    }
}