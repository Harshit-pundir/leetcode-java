class Solution {
    public int solve(TreeNode root, int num) {
        if (root == null) return 0;

        num = num * 10 + root.val;

        // Leaf node
        if (root.left == null && root.right == null) {
            return num;
        }

        return solve(root.left, num) + solve(root.right, num);
    }

    public int sumNumbers(TreeNode root) {
        return solve(root, 0);
    }
}