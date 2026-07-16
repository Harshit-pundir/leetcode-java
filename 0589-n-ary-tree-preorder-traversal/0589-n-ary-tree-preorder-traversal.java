class Solution {

    List<Integer> ans = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        dfs(root);
        return ans;
    }

    private void dfs(Node root) {
        if (root == null) return;

        ans.add(root.val);

        for (Node child : root.children) {
            dfs(child);
        }
    }
}