public class Solution {
    /**
     * @param root: the given tree
     * @return: the tree after swapping
     */
    public TreeNode bstSwappedNode(TreeNode root) {
        // write your code here
        List<TreeNode> res = new ArrayList<>();
        inorderTraversal(root, res);
        TreeNode first = null, second = null;
        for (int i = 1; i < res.size(); i++) {
            if (res.get(i).val < res.get(i - 1).val) {
                if (first == null) {
                    first = res.get(i - 1);
                } 
                second = res.get(i);

            } 
        }
        if (first != null) {
            int temp = first.val; 
            first.val = second.val;
            second.val = temp;
        }
        return root;
    }
    
    private void inorderTraversal(TreeNode root, List<TreeNode> res) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, res);
        res.add(root);
        inorderTraversal(root.right, res);
    }
}

／／ 优化

public class Solution {
    /**
     * @param root: the given tree
     * @return: the tree after swapping
     */
    TreeNode first = null, second = null;
    TreeNode pre = null;
    public TreeNode bstSwappedNode(TreeNode root) {
        // write your code here
        pre = new TreeNode(Integer.MIN_VALUE);
        inorderTraversal(root);
        if (first != null) {
            int temp = first.val; 
            first.val = second.val;
            second.val = temp;
        }
        return root;
    }
    
    private void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        if (root.val < pre.val) {
            if (first == null) {
                first = pre;
            }
            second = root;
        }
        pre = root;
        inorderTraversal(root.right);
    }
}

// 不用全局变量 

public class Solution {
    /**
     * @param root: the given tree
     * @return: the tree after swapping
     */
    TreeNode first = null, second = null;
    // TreeNode pre = null;
    public TreeNode bstSwappedNode(TreeNode root) {
        // write your code here
        TreeNode [] pre = {new TreeNode(Integer.MIN_VALUE)};
        inorderTraversal(root, pre);
        if (first != null) {
            int temp = first.val; 
            first.val = second.val;
            second.val = temp;
        }
        return root;
    }
    
    private void inorderTraversal(TreeNode root, TreeNode[] pre) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, pre);
        if (root.val < pre[0].val) {
            if (first == null) {
                first = pre[0];
            }
            second = root;
        }
        pre[0] = root;
        inorderTraversal(root.right, pre);
    }
}