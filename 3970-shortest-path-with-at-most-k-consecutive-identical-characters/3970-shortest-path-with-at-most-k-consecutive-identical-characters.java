class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {

        ArrayList<int[]>[] adj = new ArrayList[n];

        for(int i = 0; i < n; i++){
            adj[i] = new ArrayList<>();
        }

        for(int[] edge : edges){
            adj[edge[0]].add(new int[]{edge[1], edge[2]});
        }

        int[][] dist = new int[n][k+1];

        for(int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> Integer.compare(a[0],b[0])
        );

        dist[0][1] = 0;
        pq.offer(new int[]{0,0,1});

        while(!pq.isEmpty()){

            int[] curr = pq.poll();

            int cost = curr[0];
            int node = curr[1];
            int count = curr[2];

            if(cost != dist[node][count]) continue;

            if(node == n-1) return cost;

            for(int[] edge : adj[node]){

                int next = edge[0];
                int wt = edge[1];

                int newCount;

                if(labels.charAt(node) == labels.charAt(next)){
                    newCount = count + 1;
                } 
                else {
                    newCount = 1;
                }

                if(newCount > k) continue;

                int newCost = cost + wt;

                if(newCost < dist[next][newCount]){

                    dist[next][newCount] = newCost;

                    pq.offer(new int[]{
                        newCost, next, newCount
                    });
                }
            }
        }

        return -1;
    }
}