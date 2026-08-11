class Solution {
    boolean isBst = true;

    public void solve(TreeNode root, long min, long max) {
        if (root == null) return;

        if (root.val <= min || root.val >= max) {
            isBst = false;
            return;
        }

        solve(root.left, min, root.val);
        solve(root.right, root.val, max);
    }

    public boolean isValidBST(TreeNode root) {
        solve(root, Long.MIN_VALUE, Long.MAX_VALUE);
        return isBst;
    }
}