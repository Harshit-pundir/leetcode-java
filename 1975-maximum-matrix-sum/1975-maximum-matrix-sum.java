class Solution {
    public long maxMatrixSum(int[][] matrix) {

        long sum = 0;
        int negative = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                int x = Math.abs(matrix[i][j]);

                sum += x;

                if (matrix[i][j] < 0) {
                    negative++;
                }

                min = Math.min(min, x);
            }
        }

        // Odd negative numbers
        if (negative % 2 == 1) {
            sum -= 2L * min;
        }

        return sum;
    }
}