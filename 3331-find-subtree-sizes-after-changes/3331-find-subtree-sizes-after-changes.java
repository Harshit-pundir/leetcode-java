class Solution {
    int[] ans;
    List<Integer>[] tree;
    int[] last = new int[26];

    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;

        tree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        // Original tree
        for (int i = 1; i < n; i++) {
            tree[parent[i]].add(i);
        }

        int[] newParent = parent.clone();
        Arrays.fill(last, -1);

        // Find new parents
        dfs(0, s, newParent);

        // Build modified tree
        for (int i = 0; i < n; i++) {
            tree[i].clear();
        }

        for (int i = 1; i < n; i++) {
            tree[newParent[i]].add(i);
        }

        // Calculate subtree sizes
        ans = new int[n];
        size(0);

        return ans;
    }

    void dfs(int node, String s, int[] newParent) {
        int ch = s.charAt(node) - 'a';
        int prev = last[ch];

        if (prev != -1) {
            newParent[node] = prev;
        }

        last[ch] = node;

        for (int child : tree[node]) {
            dfs(child, s, newParent);
        }

        last[ch] = prev;
    }

    int size(int node) {
        ans[node] = 1;

        for (int child : tree[node]) {
            ans[node] += size(child);
        }

        return ans[node];
    }
}