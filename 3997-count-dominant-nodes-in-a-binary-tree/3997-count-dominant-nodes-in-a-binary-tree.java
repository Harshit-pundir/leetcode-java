class Solution {
    int count =0;
    public int solve(TreeNode root){
        if(root == null) return 0;
        if(root.left == null && root.right == null){
            count++;
            return root.val;
        }
        int lf = solve(root.left);
        int rt = solve(root.right);

        int max = Math.max(lf,rt);
        if(root.val >= max) count++;
        return (max <= root.val)? root.val : max;
    }
    public int countDominantNodes(TreeNode root) {
        solve(root);
        return count;
    }
}