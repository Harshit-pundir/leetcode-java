class Solution {

    public int numIslands(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int count = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){

                if(grid[i][j] == '1'){
                    count++;
                    bfs(i, j, grid);
                }
            }
        }

        return count;
    }

    public void bfs(int row, int col, char[][] grid){

        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{row, col});

        grid[row][col] = '0';

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while(!q.isEmpty()){

            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            for(int k = 0; k < 4; k++){

                int nr = r + dr[k];
                int nc = c + dc[k];

                if(nr >= 0 && nc >= 0 && nr < n && nc < m && grid[nr][nc] == '1'){

                    grid[nr][nc] = '0';
                    q.offer(new int[]{nr, nc});
                }
            }
        }
    }
}