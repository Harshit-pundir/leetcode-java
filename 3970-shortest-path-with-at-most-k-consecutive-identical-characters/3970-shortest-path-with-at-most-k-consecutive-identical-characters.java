class Solution {

    class Pair {
        int node;
        int dist;

        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    class Triplet {
        int node;
        int dist;
        int count;

        Triplet(int node, int dist, int count) {
            this.node = node;
            this.dist = dist;
            this.count = count;
        }
    }

    public int shortestPath(int n, int[][] edges, String labels, int k) {

        ArrayList<Pair>[] adj = new ArrayList[n];

        for(int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int[] edge : edges) {
            adj[edge[0]].add(new Pair(edge[1], edge[2]));
        }

        int[][] dist = new int[n][k + 1];

        for(int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<Triplet> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.dist, b.dist));

        dist[0][1] = 0;
        pq.offer(new Triplet(0, 0, 1));

        while(!pq.isEmpty()) {

            Triplet curr = pq.poll();

            int node = curr.node;
            int cost = curr.dist;
            int count = curr.count;

            if(cost != dist[node][count]) continue;

            if(node == n - 1) return cost;

            for(Pair edge : adj[node]) {

                int next = edge.node;
                int wt = edge.dist;

                int newCount;

                if(labels.charAt(node) == labels.charAt(next)) {
                    newCount = count + 1;
                }
                else {
                    newCount = 1;
                }

                if(newCount > k) continue;

                int newCost = cost + wt;

                if(newCost < dist[next][newCount]) {

                    dist[next][newCount] = newCost;

                    pq.offer(new Triplet(next, newCost, newCount));
                }
            }
        }

        return -1;
    }
}