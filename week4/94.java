public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer
     */
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        // write your code here
        dfs(root);
        return maxSum;
    }
    // This function returns the path with maximum sum STARTING FROM p (单路径)
    private int dfs(TreeNode p) {
        if(p == null) {
            return 0;
        }
        int left = dfs(p.left);
        int right = dfs(p.right);
        // the largest path passing p, and staying within p's subtree: 
        maxSum = Math.max(maxSum, left+ p.val);
        maxSum = Math.max(maxSum, right+ p.val);
        maxSum = Math.max(maxSum, right + left+ p.val);
        maxSum = Math.max(maxSum, p.val);
        
        return p.val + Math.max(0, Math.max(left, right));
    }
}