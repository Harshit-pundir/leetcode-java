class Solution {
    
    int ans = 0;

    public void dfs(TreeNode root, int left, int right) {
        if (root == null) return;

        ans = Math.max(ans, Math.max(left, right));

        // Next move should be right
        dfs(root.left, right + 1, 0);

        // Next move should be left
        dfs(root.right, 0, left + 1);
    }

    public int longestZigZag(TreeNode root) {
        dfs(root, 0, 0);
        return ans;
    }
}