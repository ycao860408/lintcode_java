public class Solution {
    /**
     * @param root: the root of binary tree
     * @return: the root of the maximum average of subtree
     */
    class NodeInfo{
        public int sum;
        public int num;
        public NodeInfo(int sum, int num) {
            this.sum = sum;
            this.num = num;
        }
    }

    TreeNode subtree = null;
    NodeInfo max = null;
    public TreeNode findSubtree2(TreeNode root) {
        // write your code here
        qft(root);
        return subtree;
    }
    
    private NodeInfo qft(TreeNode node) {
        if (node == null) {
            return new NodeInfo(0,0);
        }
        NodeInfo left = qft(node.left);
        NodeInfo right = qft(node.right);
        int sum = left.sum + right.sum + node.val;
        int num = left.num + right.num + 1;
        NodeInfo now = new NodeInfo(sum, num);
        if (subtree == null || sum * max.num > num * max.sum ) {
            max = now;
            subtree = node;
        }
        return  now;
    }
}