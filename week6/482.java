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
     * @param level: the depth of the target level
     * @return: An integer
     */
    public int levelSum(TreeNode root, int level) {
        // write your code here
        if (root == null || level < 1) {
            return 0;
        }
        int ans = 0;
        int slevel = 0;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()) {
            int size = que.size();
            ans = 0;
            slevel++;
            for (int i = 0; i < size; i++) {
                TreeNode temp = que.poll();
                ans += temp.val;
                if (temp.left != null) {
                    que.offer(temp.left);
                }
                if (temp.right != null) {
                    que.offer(temp.right);
                }
            }
            if (slevel == level) {
                break;
            }
        }
        return slevel == level ? ans : 0 ;
    }
}