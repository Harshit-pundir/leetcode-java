class Solution {
    int sum = 0;

    public void solve(TreeNode root) {
        if(root == null) return;

        if(root.left != null && 
           root.left.left == null && 
           root.left.right == null) {
            sum += root.left.val;
        }

        solve(root.left);
        solve(root.right);
    }

    public int sumOfLeftLeaves(TreeNode root) {
        solve(root);
        return sum;
    }
}