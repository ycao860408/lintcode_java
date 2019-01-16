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



public class Solution {
    /*
     * @param root: the root of binary tree
     * @param target: An integer
     * @return: all valid paths
     */
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        List<Integer> path = new ArrayList<>();
        path.add(root.val);
        int left = target - root.val;
        helper(root, left, path, res);
        return res;
    }
    
    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
    private void helper(TreeNode node, int left, List<Integer> path, List<List<Integer>> res) {
    
        if (left == 0 && isLeaf(node)) {
           res.add(new ArrayList(path)); 
        }
        if (node.left != null) {
            path.add(node.left.val);
            helper(node.left, left - node.left.val, path, res);
            path.remove(path.size() - 1);
        }
        
        if (node.right != null) {
            path.add(node.right.val);
            helper(node.right, left - node.right.val, path, res);
            path.remove(path.size() - 1);
        }
    }
}


// transversal

public class Solution {
    /*
     * @param root: the root of binary tree
     * @param target: An integer
     * @return: all valid paths
     */
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> buffer = new ArrayList<>();
        if (root == null) {
            return res;
        }
        qft(root, 0, target, res, buffer);
        return res;
    }
    
    private void qft(TreeNode root, int sum, int target, List<List<Integer>> res, List<Integer> buffer) {
        if (root == null) {
            return;
        }
        sum += root.val;
        buffer.add(root.val);
        if (root.left == null && root.right == null) {
            if (sum == target) {
                res.add(new ArrayList<Integer>(buffer));
            }
        }
        qft(root.right, sum, target, res, buffer);
        qft(root.left, sum, target, res, buffer);
        buffer.remove(buffer.size() - 1);
        
    }
}