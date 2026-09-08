class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        ArrayList<ArrayList<Integer>> nodes = new ArrayList<>();
        
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            ArrayList<Integer> level = new ArrayList<>();
            
            for(int i = 1; i<=size; i++){
                TreeNode recent = q.poll();
                if(recent.left != null) q.add(recent.left);
                if(recent.right != null) q.add(recent.right);
                level.add(recent.val);
            }
            
            nodes.add(level);
        }
        
        List<Integer> ans = new ArrayList<>();
        
        for(ArrayList<Integer> level : nodes){
            ans.add(level.get(level.size()-1));
        }
        
        return ans;
    }
}