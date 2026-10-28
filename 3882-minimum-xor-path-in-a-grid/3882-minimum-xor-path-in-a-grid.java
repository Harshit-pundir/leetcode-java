class Solution {
    private int ans;
    private int[][][] memo;

    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        ans = Integer.MAX_VALUE;
        memo = new int[m][n][1024];

        for (int[][] arr : memo) {
            for (int[] row : arr) {
                Arrays.fill(row, -1);
            }
        }

        dfs(grid, 0, 0, 0, m, n);

        return ans;
    }

    private void dfs(int[][] grid, int i, int j, int xor, int m, int n) {
        xor ^= grid[i][j];

        if (ans == 0) {
            return;
        }

        if (memo[i][j][xor] != -1) {
            return;
        }

        memo[i][j][xor] = 1;

        if (i == m - 1 && j == n - 1) {
            ans = Math.min(ans, xor);
            return;
        }

        if (i + 1 < m) {
            dfs(grid, i + 1, j, xor, m, n);
        }

        if (j + 1 < n) {
            dfs(grid, i, j + 1, xor, m, n);
        }
    }
}