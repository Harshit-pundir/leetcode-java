class Solution {
    public int solve(TreeNode root){
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        int left = solve(root.left);
        int right = solve(root.right);

        return 1 + Math.max(left,right);
    }
    public int maxDepth(TreeNode root) {
        return solve(root);
    }
}