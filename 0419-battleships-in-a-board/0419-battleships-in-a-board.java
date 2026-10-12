class Solution {
    public int countBattleships(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        int count = 0;
        for(int i = 0; i <n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 'X'){
                    count++;
                    dfs(i,j,board);
                }
            }
        }
        return count;
    }
    public void dfs(int i, int j ,char[][] board){
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != 'X') return;
        board[i][j] = '.';
        dfs(i-1,j,board);
        dfs(i+1,j,board);
        dfs(i,j+1,board);
        dfs(i,j-1,board);
    }
}