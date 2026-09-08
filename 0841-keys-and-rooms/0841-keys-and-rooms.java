class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();

        boolean[] vis = new boolean[n];

        dfs(0, vis, rooms);

        for (int i = 0; i < n; i++) {
            if (!vis[i]) return false;
        }

        return true;
    }

    public void dfs(int node, boolean[] vis, List<List<Integer>> rooms) {
        vis[node] = true;

        for (int neigh : rooms.get(node)) {
            if (!vis[neigh]) {
                dfs(neigh, vis, rooms);
            }
        }
    }
}