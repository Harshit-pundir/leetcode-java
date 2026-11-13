class Solution {
    public boolean solver(int row , int col, char[][] board){
        if(col == 9) 
            return solver(row+1,0,board);
        if(row == 9) return true;
        if(board[row][col] != '.') return solver(row,col+1,board);

        for(char ch = '1' ; ch <= '9'; ch++){
            if(isValid(row,col,ch,board)){
                board[row][col] = ch;
                if(solver(row,col+1,board)) return true;
                board[row][col] ='.';
            }
        }

        return false;
    }

    public boolean isValid(int row, int col, char ch, char[][] board){
        for(int i = 0; i < 9; i++){
            if(board[row][i] == ch) return false;

            if(board[i][col] == ch) return false;

            int r = 3 * (row / 3) + i / 3;
            int c = 3 * (col / 3) + i % 3;

            if (board[r][c] == ch)
                return false;
        }
        return true;

    }
    public void solveSudoku(char[][] board) {
        solver(0,0,board);
    }
}