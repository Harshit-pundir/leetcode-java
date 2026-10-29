class Solution {
    List<Integer>[] adj;
    int[] parent, depth, size, heavy, head, pos;
    int[] tree;
    int timer;

    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        adj = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }

        parent = new int[n];
        depth = new int[n];
        size = new int[n];
        heavy = new int[n];
        head = new int[n];
        pos = new int[n];

        Arrays.fill(parent, -1);
        Arrays.fill(heavy, -1);

        // Step 1: Build parent, depth and traversal order
        int[] order = new int[n];
        int[] stack = new int[n];
        int top = 0, count = 0;

        stack[top++] = 0;

        while (top > 0) {
            int u = stack[--top];
            order[count++] = u;

            for (int v : adj[u]) {
                if (v == parent[u]) {
                    continue;
                }

                parent[v] = u;
                depth[v] = depth[u] + 1;
                stack[top++] = v;
            }
        }

        // Step 2: Calculate subtree sizes and heavy child
        for (int i = n - 1; i >= 0; i--) {
            int u = order[i];
            size[u] = 1;
            int maxSize = 0;

            for (int v : adj[u]) {
                if (parent[v] == u) {
                    size[u] += size[v];

                    if (size[v] > maxSize) {
                        maxSize = size[v];
                        heavy[u] = v;
                    }
                }
            }
        }

        // Step 3: Heavy-Light Decomposition
        int[] starts = new int[n];
        int[] chainHeads = new int[n];
        top = 0;
        timer = 0;

        starts[top] = 0;
        chainHeads[top++] = 0;

        while (top > 0) {
            top--;

            int u = starts[top];
            int h = chainHeads[top];

            while (u != -1) {
                head[u] = h;
                pos[u] = timer++;

                for (int v : adj[u]) {
                    if (parent[v] == u && v != heavy[u]) {
                        starts[top] = v;
                        chainHeads[top] = v;
                        top++;
                    }
                }

                u = heavy[u];
            }
        }

        // Step 4: Build character bitmasks
        int[] masks = new int[n];

        for (int i = 0; i < n; i++) {
            masks[pos[i]] = 1 << (s.charAt(i) - 'a');
        }

        tree = new int[4 * n];
        build(1, 0, n - 1, masks);

        // Step 5: Process queries
        List<Boolean> ans = new ArrayList<>();

        for (String q : queries) {
            String[] p = q.split(" ");
            int u = Integer.parseInt(p[1]);

            if (p[0].equals("update")) {
                int newMask = 1 << (p[2].charAt(0) - 'a');
                update(1, 0, n - 1, pos[u], newMask);
            } else {
                int v = Integer.parseInt(p[2]);
                int mask = 0;

                while (head[u] != head[v]) {
                    if (depth[head[u]] < depth[head[v]]) {
                        int temp = u;
                        u = v;
                        v = temp;
                    }

                    mask ^= query(
                        1, 0, n - 1,
                        pos[head[u]], pos[u]
                    );

                    u = parent[head[u]];
                }

                int left = Math.min(pos[u], pos[v]);
                int right = Math.max(pos[u], pos[v]);

                mask ^= query(1, 0, n - 1, left, right);

                ans.add((mask & (mask - 1)) == 0);
            }
        }

        return ans;
    }

    // Build segment tree
    void build(int node, int l, int r, int[] arr) {
        if (l == r) {
            tree[node] = arr[l];
            return;
        }

        int mid = (l + r) / 2;

        build(node * 2, l, mid, arr);
        build(node * 2 + 1, mid + 1, r, arr);

        tree[node] = tree[node * 2] ^ tree[node * 2 + 1];
    }

    // Update one node
    void update(int node, int l, int r, int idx, int val) {
        if (l == r) {
            tree[node] = val;
            return;
        }

        int mid = (l + r) / 2;

        if (idx <= mid) {
            update(node * 2, l, mid, idx, val);
        } else {
            update(node * 2 + 1, mid + 1, r, idx, val);
        }

        tree[node] = tree[node * 2] ^ tree[node * 2 + 1];
    }

    // XOR query on a range
    int query(int node, int l, int r, int ql, int qr) {
        if (ql <= l && r <= qr) {
            return tree[node];
        }

        if (r < ql || l > qr) {
            return 0;
        }

        int mid = (l + r) / 2;

        return query(node * 2, l, mid, ql, qr)
             ^ query(node * 2 + 1, mid + 1, r, ql, qr);
    }
}
