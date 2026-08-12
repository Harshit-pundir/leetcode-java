class Solution {

    int ans = 0;
    public void dfs(int[][] grid, int row, int col, int gold) {

        if (row < 0 || col < 0 ||
            row >= grid.length || col >= grid[0].length ||
            grid[row][col] == 0) {
            return;
        }

        int value = grid[row][col];

        // collect gold
        gold += value;

        // mark visited
        grid[row][col] = 0;

        ans = Math.max(ans, gold);

        // 4 directions
        dfs(grid, row + 1, col, gold);
        dfs(grid, row - 1, col, gold);
        dfs(grid, row, col + 1, gold);
        dfs(grid, row, col - 1, gold);

        // backtrack
        grid[row][col] = value;
    }

    public int getMaximumGold(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] != 0) {
                    dfs(grid, i, j, 0);
                }
            }
        }

        return ans;
    }
}