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
     * @param root: the root of the binary tree
     * @return: An integer
     */
    int sum = 0;
    public int leafSum(TreeNode root) {
        // write your code here
        if (root == null) {
            return 0;
        }
        calc(root);
        return sum;
    }
    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
    
    private void calc(TreeNode node) {
        if (node == null) {
            return;
        }
        if (isLeaf(node)) {
            sum += node.val; 
            return;
        }
        
        calc(node.left);
        calc(node.right);
        
    }
}