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
     * @param root: A Tree
     * @return: Preorder in ArrayList which contains node values.
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        transverse(root, res);
        return res;
    }
    
    private void transverse(TreeNode root, List<Integer> res) {
        if (root != null) {
            res.add(root.val);
            transverse(root.left, res);
            transverse(root.right, res);
        }
    }
}