class NumMatrix {
    int[][] arr ;
    public NumMatrix(int[][] matrix) {
        arr = matrix.clone();
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for(int i = row1; i <= row2; i++){
            for(int j = col1; j <= col2; j++){
                sum += arr[i][j];
            }
        }

        return sum;
    }
}