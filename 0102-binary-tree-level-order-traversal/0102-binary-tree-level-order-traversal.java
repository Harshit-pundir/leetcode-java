class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;

        q.offer(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            ArrayList<Integer> res = new ArrayList<>();

            for(int i =0; i<size; i++){
                TreeNode node = q.poll();
                res.add(node.val);

                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            ans.add(res);
        }

        return ans;
    }
}