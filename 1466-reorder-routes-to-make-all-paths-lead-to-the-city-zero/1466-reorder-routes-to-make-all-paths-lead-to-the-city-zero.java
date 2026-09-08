class Solution {
    public int minReorder(int n, int[][] connections) {

        List<int[]>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : connections) {
            int u = edge[0];
            int v = edge[1];

            // u -> v is original direction
            graph[u].add(new int[]{v, 1});

            // v -> u is reverse direction
            graph[v].add(new int[]{u, 0});
        }

        boolean[] visited = new boolean[n];

        return dfs(0, graph, visited);
    }

    private int dfs(int node, List<int[]>[] graph, boolean[] visited) {

        visited[node] = true;
        int count = 0;

        for (int[] edge : graph[node]) {

            int next = edge[0];
            int cost = edge[1];

            if (!visited[next]) {
                count += cost;
                count += dfs(next, graph, visited);
            }
        }

        return count;
    }
}