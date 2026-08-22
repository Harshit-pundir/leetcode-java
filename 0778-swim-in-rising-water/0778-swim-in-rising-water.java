class Solution {
    class Pair {
        int r;
        int c;
        int height;

        Pair(int r, int c, int height) {
            this.r = r;
            this.c = c;
            this.height = height;
        }
    }

    public int swimInWater(int[][] grid) {

        int n = grid.length;

        PriorityQueue<Pair> pq =
            new PriorityQueue<>((a, b) -> a.height - b.height);

        boolean[][] visited = new boolean[n][n];

        pq.offer(new Pair(0, 0, grid[0][0]));
        visited[0][0] = true;

        int time = 0;

        int[][] dir = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        while (!pq.isEmpty()) {

            Pair curr = pq.poll();

            int r = curr.r;
            int c = curr.c;

            time = Math.max(time, curr.height);

            if (r == n - 1 && c == n - 1) {
                return time;
            }

            for (int[] d : dir) {

                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nr < n &&
                    nc >= 0 && nc < n &&
                    !visited[nr][nc]) {

                    visited[nr][nc] = true;

                    pq.offer(
                        new Pair(nr, nc, grid[nr][nc])
                    );
                }
            }
        }

        return -1;
    }
}