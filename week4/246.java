public class Solution {
    /*
     * @param root: the root of binary tree
     * @param target: An integer
     * @return: all valid paths
     */
    public List<List<Integer>> binaryTreePathSum2(TreeNode root, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> buffer = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(root, target, 0, buffer, res);
        return res;
    }
    
    private void dfs(TreeNode head, int sum, int level, List<Integer> buffer, List<List<Integer>> res) {
        if (head == null) {
            return;
        }
        int temp = sum;
        buffer.add(head.val);
        for (int i = level; i >= 0; i--) {
            temp -= buffer.get(i);
            if (temp == 0) {
                List<Integer> temp1 = new ArrayList<>();
                for (int j = i; j <= level; j++) {
                    temp1.add(buffer.get(j));
                }
                res.add(temp1);
            }
        }
        dfs(head.left, sum, level + 1, buffer, res);
        dfs(head.right, sum, level + 1, buffer, res);
        buffer.remove(buffer.size() - 1);
    }
}