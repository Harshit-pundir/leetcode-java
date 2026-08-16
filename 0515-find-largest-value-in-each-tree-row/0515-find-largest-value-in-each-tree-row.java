class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int max = Integer.MIN_VALUE;
            int size = q.size();

            for(int i =0; i <size; i++){
                TreeNode curr = q.poll();
                max = Math.max(curr.val,max);

                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }

            ans.add(max);
        }
        return ans;
    }
}