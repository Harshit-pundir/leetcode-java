class Solution {
    int[] parent;

    public int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        boolean[] ans = new boolean[requests.length];

        for (int i = 0; i < requests.length; i++) {
            int u = requests[i][0];
            int v = requests[i][1];

            int pu = find(u);
            int pv = find(v);

            boolean possible = true;

            for (int[] restriction : restrictions) {
                int a = find(restriction[0]);
                int b = find(restriction[1]);

                if ((a == pu && b == pv) || (a == pv && b == pu)) {
                    possible = false;
                    break;
                }
            }

            ans[i] = possible;

            if (possible) {
                parent[pv] = pu;
            }
        }

        return ans;
    }
}