class Solution {
    public void buildBoard(int[][] board, List<List<String>> ans){
        int n = board.length;
        List<String> res = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0 ; j < n; j++){
                if(board[i][j] == 1) sb.append('Q');
                else sb.append('.');
            }
            res.add(sb.toString());
        }
        ans.add(res);
    }
    public boolean isSafe(int row, int col, int[][] board){
        for(int i = 0; i < row; i++){
            if(board[i][col] == 1) return false;
        }

        int i = row-1;
        int j = col-1;

        while(i >= 0 && j >= 0){
            if(board[i][j] == 1) return false;
            i--;
            j--;
        }

        i = row-1;
        j = col+1;
        while(i >= 0 && j < board.length){
            if(board[i][j] == 1) return false;
            i--;
            j++;
        }

        return true;
    }
    public void solver(int row, int n,int[][] board,List<List<String>> ans){
        if(row == n){
            buildBoard(board,ans);
            return;
        }

        for(int col = 0; col < n;  col++){
            if(isSafe(row,col,board)){
                board[row][col] = 1;
                solver(row+1,n,board,ans);
                board[row][col] = 0;
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        int[][] board = new int[n][n];
        List<List<String>> ans = new ArrayList<>();
        solver(0,n,board,ans);
        return ans;
    }
}