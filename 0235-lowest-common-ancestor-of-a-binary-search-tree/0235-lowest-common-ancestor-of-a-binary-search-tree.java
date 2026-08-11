class Solution {
    public TreeNode solve(TreeNode root,TreeNode p,TreeNode q){
        if(root == null) return null;
        if(root == q || root == p) return root;

        TreeNode left = solve(root.left,p,q);
        TreeNode right = solve(root.right,p,q);

        if(left != null && right != null) return root;
        if(left != null) return left;
        return right;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return solve(root,p,q);
    }
}