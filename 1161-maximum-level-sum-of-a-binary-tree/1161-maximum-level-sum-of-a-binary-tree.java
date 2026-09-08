class Solution {
    public int maxLevelSum(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> q= new LinkedList<>();

        int level = 0;
        int ans = 0;
        int maxSum = Integer.MIN_VALUE;
        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();
            int sum = 0;

            for(int i =0; i < size; i++){
                TreeNode curr = q.poll();
                sum += curr.val;

                if(curr.left != null) q.offer(curr.left);
                if(curr.right != null) q.offer(curr.right);
            }
            level++;
            if(maxSum < sum){
                maxSum = sum;
                ans = level;
            }
        }

        return ans;
    }
}