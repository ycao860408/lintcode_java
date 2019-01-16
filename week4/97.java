/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer
     */
    public int maxDepth(TreeNode root) {
        // write your code here
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1; // devide and couquer
    }
}

// transversal

public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer
     */
    int res = 0;
    public int maxDepth(TreeNode root) {
        // write your code here
        dfs(root, 1);
        return res;
    }
    private void dfs(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (level>res) {
            res = level;
        }
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }
}