
class Solution {
    public int findMaxInd(int[][] mat, int n, int m, int row) {
        int ind = -1;
        int maxNumber = -1;

        for (int i = 0; i < m; i++) {
            if (ind == -1) {
                ind = 0;
                maxNumber = mat[row][i];
            } else if (mat[row][i] > maxNumber) {
                maxNumber = mat[row][i];
                ind = i;
            }
        }

        return ind;
    }

    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int col = findMaxInd(mat, n, m, mid);

            int left = mid - 1 >= 0 ? mat[mid - 1][col] : -1;
            int right = mid + 1 < n ? mat[mid + 1][col] : -1;

            if (mat[mid][col] > left && mat[mid][col] > right) {
                return new int[]{mid, col};
            } else if (mat[mid][col] < left) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return new int[]{-1, -1};
    }
}
