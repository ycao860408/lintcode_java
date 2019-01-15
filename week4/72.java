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
     * @param inorder: A list of integers that inorder traversal of a tree
     * @param postorder: A list of integers that postorder traversal of a tree
     * @return: Root of a tree
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // write your code here
        int n = inorder.length;
        
        if (n == 0) {
            return null;
        }
        
        int mid = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(mid);
        
        int index = 0; 
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == mid) {
                index = i;
                break;
            }
        }
        int leftInorder[] = new int[index];
        int leftPostOrer[] = new int[index];
        for (int i = 0; i < index; i++) {
            leftPostOrer[i] = postorder[i];
            leftInorder[i] = inorder[i];
        }
        
        int rightInorder[] = new int[inorder.length - 1 - index];
        int rightPostOrder[] = new int[postorder.length - 1 - index];
        
        for (int i = index + 1; i < inorder.length; i++) {
            rightInorder[i - index - 1] = inorder[i];
        }
        
        for (int i = index; i < postorder.length - 1; i++) {
            rightPostOrder[i - index] = postorder[i];
        }
        
        root.right = buildTree(rightInorder, rightPostOrder);
        root.left = buildTree(leftInorder, leftPostOrer);
        return root;
        
    }
}