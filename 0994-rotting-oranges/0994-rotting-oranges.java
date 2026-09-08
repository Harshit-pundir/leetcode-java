class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count =0;
        int total = 0;
        int minutes = 0;

        Queue<int[]> rotten = new LinkedList<>();

        for(int i =0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] == 2) rotten.add(new int[]{i,j});
                if(grid[i][j] != 0) total++;
            }
        }

        while(!rotten.isEmpty()){
            int k = rotten.size();
            count += k;

            for(int i =0; i < k; i++){
                int[] curr = rotten.poll();
                int x = curr[0];
                int y = curr[1];

                // Right
                if (y + 1 < m && grid[x][y + 1] == 1) {
                    grid[x][y + 1] = 2;
                    rotten.offer(new int[]{x, y + 1});
                }

                // Left
                if (y - 1 >= 0 && grid[x][y - 1] == 1) {
                    grid[x][y - 1] = 2;
                    rotten.offer(new int[]{x, y - 1});
                }

                // Down
                if (x + 1 < n && grid[x + 1][y] == 1) {
                    grid[x + 1][y] = 2;
                    rotten.offer(new int[]{x + 1, y});
                }

                // Up
                if (x - 1 >= 0 && grid[x - 1][y] == 1) {
                    grid[x - 1][y] = 2;
                    rotten.offer(new int[]{x - 1, y});
                }
            }

            if(!rotten.isEmpty()) minutes++;
        }

        return total == count ? minutes : -1;
    }
}