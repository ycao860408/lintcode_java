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
     * @param root: The root of binary tree
     * @return: An integer
     */
    public int minDepth(TreeNode root) {
        // write your code here
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        int res;
        if (left == 0 && right != 0) {
            res = right + 1;
        } else if (right == 0 && left != 0) {
            res = left + 1;
        } else {
            res = Math.min(left, right) + 1;
        }
        return res;
    }
}