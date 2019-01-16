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
    /*
     * @param root: The root of the binary tree.
     * @param A: A TreeNode
     * @param B: A TreeNode
     * @return: Return the LCA of the two nodes.
     */
    class Result {
        boolean a, b;
        Result(boolean aexist, boolean bexist) {
            a = aexist;
            b = bexist;
        }
    }
    TreeNode res = null;
    
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        dfs(root, A, B);
        return res;
    }
    
    private Result dfs(TreeNode p, TreeNode A, TreeNode B) {
        if (p == null) {
            return new Result(false,false);
        }
        
        Result left = dfs(p.left, A, B);
        Result right = dfs(p.right, A, B);
        boolean a = left.a || right.a || p == A;
        boolean b = left.b || right.b || p == B;
        if (a && b && res == null) {
            res = p;
        }
        return new Result(a,b);
    }
}