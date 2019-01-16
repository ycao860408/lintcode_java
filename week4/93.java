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
     * @return: True if this Binary tree is Balanced, or false.
     */
    boolean isbalance = true;
    public boolean isBalanced(TreeNode root) {
       check(root);
       return isbalance;
    }
    
    private int check(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = check(node.left);
        int rightHeight = check(node.right);
        if (Math.abs(leftHeight - rightHeight) > 1) isbalance = false;
        return Math.max(leftHeight,rightHeight) + 1;
    }
   
}