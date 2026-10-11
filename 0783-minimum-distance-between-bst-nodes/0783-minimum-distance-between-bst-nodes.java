class Solution {
    int prev = -1;
    int ans = Integer.MAX_VALUE;
    public void solve(TreeNode root){
        if(root == null) return;
        solve(root.left);
        if(prev != -1){
            ans = Math.min(ans,root.val-prev);
        }

        prev = root.val;
        solve(root.right);
    }
    public int minDiffInBST(TreeNode root) {
        solve(root);
        return ans;
    }
}