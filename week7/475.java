/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public int sum;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

// 利用bfs来更新当前从root 到当前节点的sum，然后与ans 大擂台。 
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
        int ans = Integer.MIN_VALUE;
        Queue<NewNode> que = new LinkedList<>();
        que.offer(new NewNode(root, root.val));
        while (!que.isEmpty()) {
            NewNode cur = que.poll();
            ans = Math.max(ans, cur.sum);
            if (cur.node.left != null) {
                que.offer(new NewNode(cur.node.left, cur.sum + cur.node.left.val));
            }
            if (cur.node.right != null) {
                que.offer(new NewNode(cur.node.right, cur.sum + cur.node.right.val));
            }
        }
        return ans;
    }
}

class NewNode{
        public TreeNode node;
        public int sum;
        public NewNode(TreeNode node, int sum) {
            this.sum = sum;
            this.node = node;
        }
    }
    
// DIVIDE AND CONQURE METHOD:

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
        
        int left = maxPathSum2(root.left);
        int right = maxPathSum2(root.right);
        return root.val + Math.max(0, Math.max(left,right));
    }
}