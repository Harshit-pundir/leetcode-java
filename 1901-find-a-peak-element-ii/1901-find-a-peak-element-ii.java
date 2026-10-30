class Solution {
    public int findMaxInd(int[][] mat , int n, int m , int col){
        int ind = -1;
        int maxNumber = -1;

        for(int i = 0; i < n; i++){
            if(ind == -1){
                ind = 0;
                maxNumber = mat[i][col];
            }else if(mat[i][col] > maxNumber){
                maxNumber = mat[i][col];
                ind = i;
            }
        }

        return ind;
    }
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int low = 0;
        int high = m-1;

        while(low <= high){
            int mid = low + (high - low)/2;

            int row = findMaxInd(mat,n,m,mid);
            int left = mid - 1 >= 0 ? mat[row][mid-1] : -1;
            int right = mid + 1 < m ? mat[row][mid+1] : -1;

            if(mat[row][mid] > left && mat[row][mid] > right) return new int[]{row,mid};
            else if(mat[row][mid] < left){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }

        return new int[]{-1,-1};
    }
}