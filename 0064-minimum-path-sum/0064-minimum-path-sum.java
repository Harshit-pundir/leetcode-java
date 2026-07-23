class Solution {
    public int solve(int row, int col, int[][] grid , int[][] dp){

        if(row == grid.length-1 && col == grid[0].length-1)
            return grid[row][col];

        if(row >= grid.length || col >= grid[0].length)
            return Integer.MAX_VALUE;

        if(dp[row][col] != -1) return dp[row][col];    

        int right = solve(row, col+1, grid,dp);
        int down  = solve(row+1, col, grid,dp);

        return dp[row][col] = grid[row][col] + Math.min(right, down);
    }

    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for(int[] row : dp) Arrays.fill(row,-1);

        return solve(0,0,grid,dp);
    }
}