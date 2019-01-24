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
     * @return: all root-to-leaf paths
     */
    List<String> res = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        // write your code here
        if (root == null) {
            return res;
        }
        List<String> item = new ArrayList<>();
        qft(root, item);
        return res;
    }
    private void qft(TreeNode node, List<String> item) {
        item.add(""+node.val);
        if  (node.left == null && node.right == null) {
            res.add(String.join("->", item));
        }
        if (node.left != null) {
            qft(node.left, item);
        }
        if (node.right != null) {
            qft(node.right, item);
        }
        item.remove(item.size() - 1);
    }
    
}