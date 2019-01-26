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
 
// Use the BFS to solve rather than recursively. 
class NewNode {
    TreeNode node;
    int level;
    NewNode(TreeNode node, int level) {
        this.node = node;
        this.level = level;
    }
}

public class Solution {
    /**
     * @param root: The root of binary tree
     * @return: An integer
     */
    public int minDepth(TreeNode root) {
        // write your code here
        if (root == null) {
            return 0;
        }
        Queue<NewNode> que = new LinkedList<>();
        que.add(new NewNode(root, 1));
        int ans = 0;
        while (!que.isEmpty()) {
            NewNode cur = que.poll();
            if (cur.node.left == null && cur.node.right == null) {
                ans = cur.level;
                break;
            } else {
                if (cur.node.left != null) {
                    que.offer(new NewNode(cur.node.left, cur.level + 1));
                }
                if (cur.node.right != null) {
                    que.offer(new NewNode(cur.node.right, cur.level + 1));
                }
            }
        }
        return ans;
    }
}