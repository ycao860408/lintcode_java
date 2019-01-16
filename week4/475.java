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
     * @param root: the root of binary tree.
     * @return: An integer
     */
    public int maxPathSum2(TreeNode root) {
        // write your code here
        if (root == null) {
            return 0;
        }
        
        int right = maxPathSum2(root.right);
        int left = maxPathSum2(root.left);
        return Math.max(0, Math.max(right, left)) + root.val;
    }
}

// If we want to print out the path to the root. use the result to record the tail of the path.
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

public class Solution{
    private class Result{
        int sum; 
        TreeNode tail;
        Result (int sum, TreeNode tail) {
            this.sum = sum;
            this.tail = tail;
        }
    }
    
    private Result dfs(TreeNode node) {
        if (node == null) {
            return new Result(Integer.MIN_VALUE, null);
        }
        Result left = dfs(node.left);
        Result right = dfs(node.right);
        int sum = node.val + Math.max(0, Math.max(left.sum, right.sum));
        TreeNode tail = null;
        if (sum == node.val + left.sum) {
            tail = node.left;
        } else if (sum == node.val + right.sum) {
            tail = node.right;
        } else {
            tail = node;
        }
        return new Result(sum, tail);
    }
    
    
    public int maxPathSum2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        Result r = dfs(root);
        System.out.println(r.tail.val);
        return r.sum;
    }
}