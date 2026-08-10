class Solution {
    boolean isIdentical = true;
    public boolean solve(TreeNode p , TreeNode q){
        if((p == null && q != null) || (q == null && p != null)){
            isIdentical = false;
            return false;
        } 
        
        if(p == null && q == null) return true;
        if(p.val != q.val){
            isIdentical = false;
            return false;
        }

        return solve(p.left,q.left) && solve(p.right,q.right);
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
         solve(p,q);
         return isIdentical;
    }
}