class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {

        int n = grid.length;

        // Total numbers = n * n
        long N = (long) n * n;

        // Sum of 1 to N
        long SN = (N * (N + 1)) / 2;

        // Sum of squares of 1 to N
        long S2N = (N * (N + 1) * (2 * N + 1)) / 6;

        long S = 0;
        long S2 = 0;

        // Calculate actual sum and square sum
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                S += grid[i][j];

                S2 += (long) grid[i][j] * grid[i][j];
            }
        }

        // repeating - missing
        long val1 = S - SN;

        // repeating² - missing²
        long val2 = S2 - S2N;

        // repeating + missing
        val2 = val2 / val1;

        // repeating
        long repeating = (val1 + val2) / 2;

        // missing
        long missing = repeating - val1;

        return new int[]{
            (int) repeating,
            (int) missing
        };
    }
}