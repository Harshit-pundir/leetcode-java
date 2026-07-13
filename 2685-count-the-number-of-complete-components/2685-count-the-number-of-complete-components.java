class Solution {
    public int countCompleteComponents(int n, int[][] edges) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] vis = new boolean[n];
        int ans = 0;

        for (int i = 0; i < n; i++) {

            if (!vis[i]) {

                Queue<Integer> q = new LinkedList<>();
                q.offer(i);
                vis[i] = true;

                int nodes = 0;
                int degreeSum = 0;

                while (!q.isEmpty()) {

                    int node = q.poll();
                    nodes++;
                    degreeSum += adj.get(node).size();

                    for (int nei : adj.get(node)) {
                        if (!vis[nei]) {
                            vis[nei] = true;
                            q.offer(nei);
                        }
                    }
                }

                int actualEdges = degreeSum / 2;
                int requiredEdges = nodes * (nodes - 1) / 2;

                if (actualEdges == requiredEdges) {
                    ans++;
                }
            }
        }

        return ans;
    }
}