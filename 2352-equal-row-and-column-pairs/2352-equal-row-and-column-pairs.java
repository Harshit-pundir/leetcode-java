class Solution {

    public boolean isValid(int row, int col, int[][] grid) {
        int n = grid.length;

        for (int i = 0; i < n; i++) {
            if (grid[row][i] != grid[i][col]) {
                return false;
            }
        }

        return true;
    }

    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int count = 0;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (isValid(row, col, grid)) {
                    count++;
                }
            }
        }

        return count;
    }
}