import java.util.*;

class Solution {
    public int minCostConnectPoints(int[][] points) {

        int n = points.length;

        boolean[] vis = new boolean[n];

        // {cost, node}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        pq.offer(new int[]{0, 0});

        int ans = 0;

        while (!pq.isEmpty()) {

            int[] curr = pq.poll();

            int cost = curr[0];
            int node = curr[1];

            if (vis[node]) continue;

            vis[node] = true;
            ans += cost;

            for (int i = 0; i < n; i++) {

                if (!vis[i]) {

                    int dist = Math.abs(points[node][0] - points[i][0])
                             + Math.abs(points[node][1] - points[i][1]);

                    pq.offer(new int[]{dist, i});
                }
            }
        }

        return ans;
    }
}