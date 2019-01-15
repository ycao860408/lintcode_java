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
     * @return: root of new tree
     */
    TreeNode res;
    public TreeNode cloneTree(TreeNode root) {
        // write your code here
        if (root == null) {
            return null;
        }
        res = new TreeNode(root.val);
        res.left = helper(res.left, root.left);
        res.right = helper(res.right, root.right);
        return res;
    }
    
    private TreeNode helper(TreeNode ans, TreeNode origin) {
        if (origin == null) {
            return null;
        }
        ans = new TreeNode(origin.val);
        ans.left = helper(ans.left, origin.left);
        ans.right = helper(ans.right, origin.right);
        return ans;
    }
    
    
}