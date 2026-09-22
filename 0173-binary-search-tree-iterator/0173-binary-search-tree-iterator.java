class BSTIterator {

    Stack<TreeNode> st;

    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        pushAllLeft(root);
    }

    public int next() {
        TreeNode curr = st.pop();

        if (curr.right != null)
            pushAllLeft(curr.right);

        return curr.val;
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }

    private void pushAllLeft(TreeNode root) {
        while (root != null) {
            st.push(root);
            root = root.left;
        }
    }
}