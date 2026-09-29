class Solution {

    int[][] dir = {
        {0, 1},   // right
        {0, -1},  // left
        {1, 0},   // down
        {-1, 0}   // up
    };

    public boolean hasValidPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        return dfs(0, 0, grid, visited);
    }

    boolean dfs(int i, int j, int[][] grid, boolean[][] visited) {

        int m = grid.length;
        int n = grid[0].length;

        if (i == m - 1 && j == n - 1)
            return true;

        visited[i][j] = true;

        int type = grid[i][j];

        // Street 1 -> left, right
        if (type == 1) {

            // right
            if (j + 1 < n && !visited[i][j + 1]
                    && (grid[i][j + 1] == 1 ||
                        grid[i][j + 1] == 3 ||
                        grid[i][j + 1] == 5)) {

                if (dfs(i, j + 1, grid, visited))
                    return true;
            }

            // left
            if (j - 1 >= 0 && !visited[i][j - 1]
                    && (grid[i][j - 1] == 1 ||
                        grid[i][j - 1] == 4 ||
                        grid[i][j - 1] == 6)) {

                if (dfs(i, j - 1, grid, visited))
                    return true;
            }
        }

        // Street 2 -> up, down
        else if (type == 2) {

            // down
            if (i + 1 < m && !visited[i + 1][j]
                    && (grid[i + 1][j] == 2 ||
                        grid[i + 1][j] == 5 ||
                        grid[i + 1][j] == 6)) {

                if (dfs(i + 1, j, grid, visited))
                    return true;
            }

            // up
            if (i - 1 >= 0 && !visited[i - 1][j]
                    && (grid[i - 1][j] == 2 ||
                        grid[i - 1][j] == 3 ||
                        grid[i - 1][j] == 4)) {

                if (dfs(i - 1, j, grid, visited))
                    return true;
            }
        }

        // Street 3 -> left, down
        else if (type == 3) {

            // left
            if (j - 1 >= 0 && !visited[i][j - 1]
                    && (grid[i][j - 1] == 1 ||
                        grid[i][j - 1] == 4 ||
                        grid[i][j - 1] == 6)) {

                if (dfs(i, j - 1, grid, visited))
                    return true;
            }

            // down
            if (i + 1 < m && !visited[i + 1][j]
                    && (grid[i + 1][j] == 2 ||
                        grid[i + 1][j] == 5 ||
                        grid[i + 1][j] == 6)) {

                if (dfs(i + 1, j, grid, visited))
                    return true;
            }
        }

        // Street 4 -> right, down
        else if (type == 4) {

            // right
            if (j + 1 < n && !visited[i][j + 1]
                    && (grid[i][j + 1] == 1 ||
                        grid[i][j + 1] == 3 ||
                        grid[i][j + 1] == 5)) {

                if (dfs(i, j + 1, grid, visited))
                    return true;
            }

            // down
            if (i + 1 < m && !visited[i + 1][j]
                    && (grid[i + 1][j] == 2 ||
                        grid[i + 1][j] == 5 ||
                        grid[i + 1][j] == 6)) {

                if (dfs(i + 1, j, grid, visited))
                    return true;
            }
        }

        // Street 5 -> left, up
        else if (type == 5) {

            // left
            if (j - 1 >= 0 && !visited[i][j - 1]
                    && (grid[i][j - 1] == 1 ||
                        grid[i][j - 1] == 4 ||
                        grid[i][j - 1] == 6)) {

                if (dfs(i, j - 1, grid, visited))
                    return true;
            }

            // up
            if (i - 1 >= 0 && !visited[i - 1][j]
                    && (grid[i - 1][j] == 2 ||
                        grid[i - 1][j] == 3 ||
                        grid[i - 1][j] == 4)) {

                if (dfs(i - 1, j, grid, visited))
                    return true;
            }
        }

        // Street 6 -> right, up
        else {

            // right
            if (j + 1 < n && !visited[i][j + 1]
                    && (grid[i][j + 1] == 1 ||
                        grid[i][j + 1] == 3 ||
                        grid[i][j + 1] == 5)) {

                if (dfs(i, j + 1, grid, visited))
                    return true;
            }

            // up
            if (i - 1 >= 0 && !visited[i - 1][j]
                    && (grid[i - 1][j] == 2 ||
                        grid[i - 1][j] == 3 ||
                        grid[i - 1][j] == 4)) {

                if (dfs(i - 1, j, grid, visited))
                    return true;
            }
        }

        return false;
    }
}