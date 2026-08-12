import java.util.*;

class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {

        int m = grid.length;
        int n = grid[0].length;

        for (int l = 0; l < Math.min(m, n) / 2; l++) {

            int top = l;
            int left = l;
            int bottom = m - 1 - l;
            int right = n - 1 - l;

            // Store layer
            ArrayList<Integer> a = new ArrayList<>();

            // top
            for (int j = left; j <= right; j++)
                a.add(grid[top][j]);

            // right
            for (int i = top + 1; i <= bottom; i++)
                a.add(grid[i][right]);

            // bottom
            for (int j = right - 1; j >= left; j--)
                a.add(grid[bottom][j]);

            // left
            for (int i = bottom - 1; i > top; i--)
                a.add(grid[i][left]);


            // Rotate
            int shift = k % a.size();

            ArrayList<Integer> b = new ArrayList<>();

            for (int i = shift; i < a.size(); i++)
                b.add(a.get(i));

            for (int i = 0; i < shift; i++)
                b.add(a.get(i));


            // Put back
            int x = 0;

            for (int j = left; j <= right; j++)
                grid[top][j] = b.get(x++);

            for (int i = top + 1; i <= bottom; i++)
                grid[i][right] = b.get(x++);

            for (int j = right - 1; j >= left; j--)
                grid[bottom][j] = b.get(x++);

            for (int i = bottom - 1; i > top; i--)
                grid[i][left] = b.get(x++);
        }

        return grid;
    }
}