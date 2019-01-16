/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


public class Solution {
    /*
     * @param root: The root of the BST.
     * @param p: You need find the successor node of p.
     * @return: Successor of p.
     */
    TreeNode post = null;
    TreeNode target = null;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // write your code here
        if (root == null || root.left == null && root.right == null) {
            return null;
        }
        qft(root,p);
        
        if (target == null) {
            return null;
        }
        
        if (target.right !=  null) {
            TreeNode cur = target.right;
            while  (cur.left != null) {
                cur = cur.left;
            }
            return cur;
        }
        return post;
    }
    
    private void qft (TreeNode root, TreeNode p) {
        if (root == null) {
            return;
        } 
        if (root.val == p.val) {
            target = root;
            return;
        }
        if (p.val < root.val) {
            post = root;
            qft(root.left, p);
        } else {
            qft(root.right, p);
        }
    }
    
    
}