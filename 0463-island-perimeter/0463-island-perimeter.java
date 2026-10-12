class Solution {
    int ans = 0;
    public int islandPerimeter(int[][] grid) {
        ans = 0;
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] isVisited = new boolean[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    dfs(i,j,grid,isVisited);
                    
                    return ans;
                    
                }
            }
        }
        return ans;
    }
    public void dfs(int i , int j , int[][] grid , boolean[][] isVisited){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0){
            ans += 1;
            return;
        }
        if(isVisited[i][j] ) {
           
            return;
        }

        isVisited[i][j] = true;

        dfs(i-1,j,grid , isVisited);
        dfs(i+1,j,grid , isVisited);
        dfs(i,j-1,grid , isVisited);
        dfs(i,j+1,grid , isVisited);
    }
}