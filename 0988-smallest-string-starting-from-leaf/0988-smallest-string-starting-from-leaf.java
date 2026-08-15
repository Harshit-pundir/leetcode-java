class Solution {
    String ans = "";
    int min = Integer.MAX_VALUE;

    public void solve(TreeNode root, String res, int len) {
        if (root == null) {
            return;
        }

        res = (char)('a' + root.val) + res;
        len++;

        // Leaf node
        if (root.left == null && root.right == null) {
            if (ans.equals("") || res.compareTo(ans) < 0) {
                ans = res;
            }
            return;
        }

        solve(root.left, res, len);
        solve(root.right, res, len);
    }

    public String smallestFromLeaf(TreeNode root) {
        solve(root, "", 0);
        return ans;
    }
}