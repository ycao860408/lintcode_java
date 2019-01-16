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
     * @param root: param root: The root of the binary search tree
     * @param k1: An integer
     * @param k2: An integer
     * @return: return: Return all keys that k1<=key<=k2 in ascending order
     */
    List<Integer> res = new ArrayList<>();
    public List<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
        qft(root, k1, k2);
        return res;
    }
    
    private void qft(TreeNode root, int k1, int k2) {
        if (root == null) {
            return;
        }
        if (root.val >=k1 && root.val<= k2) {
            res.add(root.val);
        }
        qft(root.left, k1, k2);
        qft(root.right, k1, k2);
    }
}