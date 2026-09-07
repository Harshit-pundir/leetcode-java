class Solution {
    
    int count = 0;
    public void solve(TreeNode root,int greater){
        if(root == null) return;
        if(root.val >= greater){
            greater = root.val;
            count++;
        }

        solve(root.left,greater);
        solve(root.right,greater);
    }
    public int goodNodes(TreeNode root) {
        count =0;
        solve(root,Integer.MIN_VALUE);
        return count;
    }
}