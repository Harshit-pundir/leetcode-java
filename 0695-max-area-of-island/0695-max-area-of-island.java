class Solution {
    int count = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int ans = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    count = 0;
                    dfs(i,j,grid);
                    ans = Math.max(ans,count);
                }
            }
        }

        return ans == Integer.MIN_VALUE ? 0 : ans;
    }

    public void dfs(int i, int j , int[][] grid){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1) return;
        count++;

        grid[i][j] = 0;

        dfs(i+1,j,grid);
        dfs(i-1,j,grid);
        dfs(i,j-1,grid);
        dfs(i,j+1,grid);


    }
}