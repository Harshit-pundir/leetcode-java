
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;

        if(root.val < key) root.right = deleteNode(root.right, key); 
        else if(root.val > key) root.left = deleteNode(root.left, key);
        else{
            if(root.left == null) return root.right;
            else if(root.right == null) return root.left;
            else{
                TreeNode minVal = getMin(root.right);
                root.val = minVal.val;
                root.right = deleteNode(root.right,minVal.val);
            }
            
        }

        return root;
    }

    public TreeNode getMin(TreeNode root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }
}