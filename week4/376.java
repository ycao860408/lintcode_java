public class Solution {
    /*
     * @param root: the root of binary tree
     * @param target: An integer
     * @return: all valid paths
     */
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // write your code here
        List<List<Integer>> res = new ArrayList<> ();
        if (root == null) {
            return res;
        } 
        int sum = 0;
        List<Integer> item = new ArrayList<>();
        item.add(root.val);
        sum += root.val;
        helper(root, sum, target, item, res);
        return res;
        
    }
    
    private void helper(TreeNode node, int sum, int target, List<Integer> path, List<List<Integer>> res) {
        if (node.right == null && node.left == null) {
            if ( sum == target) {
                res.add(new ArrayList(path));
            }
        }
        
        if (node.right != null) {
            path.add(node.right.val);
            helper(node.right, sum + node.right.val, target, path, res);
            path.remove(path.size() - 1);
        }
        
        if (node.left != null) {
            path.add(node.left.val);
            helper(node.left, sum + node.left.val, target, path, res);
            path.remove(path.size() - 1);
        }
    }
}