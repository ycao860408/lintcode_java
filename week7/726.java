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
     * @param root: the given tree
     * @return: Whether it is a full tree
     */
    public boolean isFullTree(TreeNode root) {
        // write your code here
        if (root == null) {
            return true;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            // do something: 
            // check if current is valid: 
            // add new node into queue. 
            if (cur.left != null && cur.right != null) {
                queue.offer(cur.left);
                queue.offer(cur.right);
            } else if (!(cur.left == null && cur.right == null)) {
                return false;
            }
        }
        return true;
    }
}

／／递归实现的遍历 

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
     * @param root: the given tree
     * @return: Whether it is a full tree
     */
    public boolean isFullTree(TreeNode root) {
        // write your code here
        if (root == null) return true;
        if ((root.left != null && root.right != null) || (root.left == null && root.right == null)) {
            boolean left = isFullTree(root.left);
            boolean right = isFullTree(root.right);
            return left && right;
        }
        return false;
    }
}