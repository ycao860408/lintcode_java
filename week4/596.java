public class Solution {
    /**
     * @param root: the root of binary tree
     * @return: the root of the minimum subtree
     */
    int min = Integer.MAX_VALUE;
    TreeNode subtree;
    
    public TreeNode findSubtree(TreeNode root) {
        // write your code here
        qft(root);
        return subtree;
    }
    
    private int qft(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int sum = qft(node.left) + qft(node.right) + node.val;
        if (sum < min) {
            subtree = node;
            min = sum;
        }
        return sum;
    }
}