class Solution {

    public int solve(int i, int j, int[][] grid, boolean[][] vis,
                     int n, int m, int empty) {

        // Out of bounds / obstacle / already visited
        if (i < 0 || j < 0 || i >= n || j >= m ||
            grid[i][j] == -1 || vis[i][j]) {
            return 0;
        }

        // Destination
        if (grid[i][j] == 2) {
            return empty == 1 ? 1 : 0;
        }

        vis[i][j] = true;

        int left = solve(i, j - 1, grid, vis, n, m, empty - 1);
        int right = solve(i, j + 1, grid, vis, n, m, empty - 1);
        int down = solve(i + 1, j, grid, vis, n, m, empty - 1);
        int up = solve(i - 1, j, grid, vis, n, m, empty - 1);

        vis[i][j] = false;

        return left + right + down + up;
    }

    public int uniquePathsIII(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];

        int si = 0;
        int sj = 0;
        int empty = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] != -1) {
                    empty++;
                }

                if (grid[i][j] == 1) {
                    si = i;
                    sj = j;
                }
            }
        }

        return solve(si, sj, grid, vis, n, m, empty);
    }
}