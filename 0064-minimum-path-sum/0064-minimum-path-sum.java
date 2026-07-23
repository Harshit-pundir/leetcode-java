class Solution {

    public int solve(int row, int col, int[][] grid, int[][] dp) {

        if (row == grid.length - 1 && col == grid[0].length - 1)
            return grid[row][col];

        if (row >= grid.length || col >= grid[0].length)
            return (int)1e9;

        if (dp[row][col] != -1)
            return dp[row][col];

        int right = solve(row, col + 1, grid, dp);
        int down = solve(row + 1, col, grid, dp);

        return dp[row][col] = grid[row][col] + Math.min(right, down);
    }

    public int minPathSum(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int[][] dp = new int[n][m];

        for(int row = n-1; row>= 0; row--){
            for(int col = m-1; col >= 0; col--){
                if (row == n - 1 && col == m - 1) dp[row][col] = grid[row][col];
                else{
                    int right = (col + 1 >= m) ? (int)1e9 : dp[row][col+1];
                    int down = (row + 1 >= n) ? (int)1e9 : dp[row+1][col];

                    dp[row][col] = grid[row][col] + Math.min(right, down);
                }
            }
        }

        return dp[0][0];
    }
}