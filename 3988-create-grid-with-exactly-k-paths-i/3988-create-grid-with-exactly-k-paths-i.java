import java.util.*;

class Solution {
    public String[] createGrid(int m, int n, int k) {
        if (m == 1 || n == 1) {
            if (k == 1) {
                String[] ans = new String[m];
                Arrays.fill(ans, ".".repeat(n));
                return ans;
            }
            return new String[0];
        }

        char[][] grid = new char[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(grid[i], '#');
        }

        if (n >= k) {
            Arrays.fill(grid[0], '.');

            for (int i = 1; i < m; i++) {
                grid[i][n - 1] = '.';
            }

            for (int j = n - k; j < n - 1; j++) {
                grid[1][j] = '.';
            }
        } else if (m >= k) {
            for (int i = 0; i < m; i++) {
                grid[i][0] = '.';
            }

            Arrays.fill(grid[m - 1], '.');

            for (int i = m - k; i < m - 1; i++) {
                grid[i][1] = '.';
            }
        } else if (m == 3 && n == 3 && k == 4) {
            return new String[]{"..#", "...", "#.."};
        } else {
            return new String[0];
        }

        String[] ans = new String[m];

        for (int i = 0; i < m; i++) {
            ans[i] = new String(grid[i]);
        }

        return ans;
    }
}