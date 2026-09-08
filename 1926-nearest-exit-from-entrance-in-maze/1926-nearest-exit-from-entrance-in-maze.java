class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int n = maze.length;
        int m = maze[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.offer(entrance);

        maze[entrance[0]][entrance[1]] ='+';

        int steps =0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        while(!q.isEmpty()){
            int size = q.size();
            steps++;

            for(int i =0; i <size; i++){
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];


                for(int[] dir : dirs){
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    
                    if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                        continue;
                    }

                    
                    if (maze[nr][nc] == '+') {
                        continue;
                    }

                    
                    if (nr == 0 || nr == n - 1 || nc == 0 || nc == m - 1) {
                        return steps;
                    }

                   
                    maze[nr][nc] = '+';
                    q.offer(new int[]{nr, nc});
                }
            }
        }

        return -1;
    }
}