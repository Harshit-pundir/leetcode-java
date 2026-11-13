class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == word.charAt(0))
                if(dfs(board,i,j,0,word)) return true;
            }
        }

        return false;
    }
    public boolean dfs(char[][] board , int i, int j ,int idx, String word){
        if(idx == word.length()) return true;
        if(i >= board.length || j >= board[0].length || i < 0 || j < 0 || word.charAt(idx) != board[i][j]) return false;

        char temp = board[i][j];
        board[i][j] = '#';

        boolean down = dfs(board, i + 1, j, idx + 1 , word);
        boolean up = dfs(board, i - 1, j, idx + 1 , word);
        boolean right = dfs(board, i, j + 1, idx + 1 , word);
        boolean left = dfs(board , i, j - 1, idx + 1 , word);

        boolean found = down || up || right || left;

        board[i][j] = temp;

        return found;
    }
}