class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {

        int n = grid.length;
        int m = grid[0].length;

        while (k-- > 0) {

            int[][] temp = new int[n][m];

            temp[0][0] = grid[n - 1][m - 1];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {

                    if (i == 0 && j == 0)
                        continue;

                    if (j == 0)
                        temp[i][j] = grid[i - 1][m - 1];
                    else
                        temp[i][j] = grid[i][j - 1];
                }
            }

            grid = temp;
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                list.add(grid[i][j]);
            }
            ans.add(list);
        }

        return ans;
    }
}