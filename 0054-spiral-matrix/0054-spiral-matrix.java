class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;

        int topRow = 0;
        int bottomRow = n-1;
        int leftCol = 0;
        int rightCol = m -1;

        int currElements = 0;
        int totalElements = n * m;

        while(currElements < totalElements){
            for(int j = leftCol;  j<= rightCol && currElements < totalElements; j++){
                ans.add(matrix[topRow][j]);
                currElements++;
            }
            topRow++;

            for(int i = topRow; i <= bottomRow && currElements < totalElements; i++){
                ans.add(matrix[i][rightCol]);
                currElements++;
            }
            rightCol--;

            for(int j = rightCol; j >= leftCol && currElements < totalElements; j--){
                ans.add(matrix[bottomRow][j]);
                currElements++;
            }
            bottomRow--;

            for(int i = bottomRow ; i>= topRow && currElements < totalElements; i--){
                ans.add(matrix[i][leftCol]);
                currElements++;
            }
            leftCol++;
        }

        return ans;
    }
}