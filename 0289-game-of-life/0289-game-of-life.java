class Solution {
    public void gameOfLife(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[][] nums = new int[n][m];

        for(int i = 0; i<n; i++){
            for(int j =0; j < m; j++){
                int neighbourLive = checkLive(i,j,board,nums);
                int current= board[i][j];
                if(current == 1){
                    if(neighbourLive < 2) current = 0;
                    else if(neighbourLive == 2 || neighbourLive == 3) current = 1;
                    else current = 0;
                }else{
                    if(neighbourLive == 3) current = 1;
                    else current = 0;
                }

                nums[i][j] = current;
            }
        }

        for(int i = 0; i<n; i++){
            for(int j =0; j < m; j++){
                board[i][j] = nums[i][j];
            }
        }
    }

    public int checkLive(int i , int j , int[][] board, int[][] nums){
        int neighbourLive = 0;

        if(i > 0 && j > 0){
            neighbourLive += board[i-1][j-1];
        }if(i > 0 && j >= 0){
            neighbourLive += board[i-1][j];
        }if(i > 0 && j < board[0].length-1){
            neighbourLive += board[i-1][j+1];
        }if(i >= 0 && j > 0){
            neighbourLive += board[i][j-1];
        }if(i >= 0 && j < board[0].length-1){
            neighbourLive += board[i][j+1];
        }if(i < board.length-1 && j > 0){
            neighbourLive += board[i+1][j-1];
        }if(i < board.length-1 && j >= 0){
            neighbourLive += board[i+1][j];
        }
        if(i < board.length-1 && j < board[0].length-1){
            neighbourLive += board[i+1][j+1];
        }

        return neighbourLive;
    }
}