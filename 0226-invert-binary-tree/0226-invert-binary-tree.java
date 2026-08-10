class Solution {
    public TreeNode solve(TreeNode root){
        if(root == null) return null;
        if(root.left == null && root.right == null) return root;

        TreeNode left = solve(root.left);
        TreeNode right = solve(root.right);

        root.left = right;
        root.right = left;
        return root;
    }
    public TreeNode invertTree(TreeNode root) {
        return solve(root);
    }
}