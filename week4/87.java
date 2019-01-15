 public TreeNode removeNode(TreeNode root, int value) {
        // write your code here
        if (root == null) {
            return root;
        }
        if (value < root.val) 
            root.left = removeNode(root.left, value);
        else if (value > root.val) {
            root.right = removeNode(root.right, value);
        }else {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left != null && root.right != null) {
                TreeNode leftMax = find (root.left);
                root.val = leftMax.val;
                root.left = removeNode(root.left, leftMax.val);
            } else {
                if (root.left != null) {
                    return root.left;
                } else {
                    return root.right;
                }
            }
        }
        return root;
    }
    
    private TreeNode find(TreeNode node) {
       if (node.right == null) {
           return node;
       }
       return find(node.right);
    }
}