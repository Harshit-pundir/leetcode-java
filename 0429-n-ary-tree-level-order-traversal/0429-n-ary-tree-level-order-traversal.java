class Solution {
    public List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) return ans;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {

            int size = q.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {

                Node curr = q.poll();
                level.add(curr.val);

                for (Node child : curr.children) {
                    q.offer(child);
                }
            }

            ans.add(level);
        }

        return ans;
    }
}