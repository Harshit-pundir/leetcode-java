class Solution {

    public int networkDelayTime(int[][] times, int n, int k) {

        // adjacency list
        ArrayList<int[]>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];

            graph[u].add(new int[]{v, w});
        }

        // distance array
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[k] = 0;

        // {distance, node}
        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> a[0] - b[0]);

        pq.offer(new int[]{0, k});

        while (!pq.isEmpty()) {

            int[] curr = pq.poll();

            int distance = curr[0];
            int node = curr[1];

            if (distance > dist[node])
                continue;

            for (int[] edge : graph[node]) {

                int nextNode = edge[0];
                int weight = edge[1];

                int newDist = distance + weight;

                if (newDist < dist[nextNode]) {

                    dist[nextNode] = newDist;

                    pq.offer(new int[]{
                        newDist,
                        nextNode
                    });
                }
            }
        }

        int ans = 0;

        for (int i = 1; i <= n; i++) {

            if (dist[i] == Integer.MAX_VALUE)
                return -1;

            ans = Math.max(ans, dist[i]);
        }

        return ans;
    }
}