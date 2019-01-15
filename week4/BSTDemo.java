import java.util.Queue;
import java.util.LinkedList; 
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}

class BST {
    TreeNode head;
    BST() {
        head = null;
    }
    BST(int val) {
        head = new TreeNode(val);
    }
    BST(BST bst) {
        if (bst.head == null) {
            head = null;
        } else {
            head = new TreeNode(bst.head.val);
            head.left = clone(head.left, bst.head.left);
            head.right = clone(head.right, bst.head.right);
        }
    }
    private TreeNode clone(TreeNode copy, TreeNode origin) {
        if (origin == null) {
            return null;
        }
        copy = new TreeNode(origin.val);
        copy.left = clone(copy.left, origin.left);
        copy.right = clone(copy.right, origin.right);
        return copy;
    }
    
    void insert(int val) {
        head = insert(head, val);
    }
    private TreeNode insert(TreeNode node, int val) {
        if (node == null) {
            return new TreeNode(val);
        }
        if (val < node.val) {
            node.left = insert(node.left, val);
        } else {
            node.right = insert(node.right, val);
        }
        return node;
    }
    
    boolean search(int val) {
        return searchTree(head, val);
    }
    private boolean searchTree(TreeNode head, int val) {
        if (head == null) {
            return false;
        }
        if (head.val == val) {
            return true;
        } else if (val < head.val) {
            return searchTree(head.left, val);
        } else {
            return searchTree(head.right, val);
        }
    }
    void delete(int val) {
        if (search(val)) {
            head = delete(head, val);
        } else {
            System.out.println("No such value in the BST");
        }
    }
    
    private TreeNode delete(TreeNode root, int val) {
       if (val < root.val) {
           root.left = delete(root.left, val);
       } else if (val > root.val) {
           root.right = delete(root.right, val);
       } else {
           if (root.left == null && root.right == null) {
               return null;
           } else if (root.left != null && root.right != null) {
               int leftMax = find(root.left);
               root.val = leftMax;
               root.left = delete(root.left, leftMax);
           } else {
               if (root.left != null) {
                   return root.left;
               }
               if (root.right != null) {
                   return root.right;
               }
           }
       }
       return root;
    }
    
    private int find(TreeNode node) {
        if (node.right == null) {
            return node.val;
        }
        return find(node.right);
    }
    
   
    void treePrint(String type) {
        if (head == null) {
            System.out.print("This is an empty tree.");
        } else {
            switch(type) {
                case "in":
                    privateInOrder(head);
                    break;
                case "pre":
                    privatePreOrder(head);
                    break;
                case "post":
                    privatePostOrder(head);
                    break;
                case "level":
                    privateLevelOrder(head);
                    break;
            }
        }
    }
    
    private void privateInOrder(TreeNode node) {
        if (node != null) {
            privateInOrder(node.left);
            System.out.print(node.val + " ");
            privateInOrder(node.right);
        }
    }
    
    private void privatePreOrder(TreeNode node) {
        if (node != null) {
            System.out.print(node.val + " ");
            privatePreOrder(node.left);
            privatePreOrder(node.right);
        }
    }
    
    private void privatePostOrder(TreeNode node) {
        if (node != null) {
            privatePostOrder(node.left);
            privatePostOrder(node.right);
            System.out.print(node.val + " ");
        }
    }
    
    private void privateLevelOrder(TreeNode node) {
        Queue <TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        int len = queue.size();
        while (len != 0) {
            for (int i = 0; i < len; i++) {
                TreeNode temp = queue.poll();
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
                System.out.print(temp.val + " ");
            }
            System.out.println();
            len = queue.size();
        }
    }
}

public class BSTDemo{
    public static void main(String args[]) {
        BST bst = new BST(5);
        int nums[] = {1,2,3,4,0,6,7,8,9,10};
        for (int i = 0; i < nums.length; i++) {
            bst.insert(nums[i]);
        }
        bst.treePrint("in");
        System.out.println();
        bst.treePrint("post");
        System.out.println();
        bst.treePrint("level");
        System.out.println();
        bst.treePrint("pre");
        System.out.println();
        System.out.println(bst.search(100));
        bst.delete(100);
        bst.delete(0);
        bst.treePrint("in");
        System.out.println();
        bst.treePrint("post");
        System.out.println();
        bst.treePrint("level");
        System.out.println();
        bst.treePrint("pre");
        System.out.println();
        BST bst2 = new BST(bst);
        bst2.treePrint("in");
        System.out.println();
        bst2.treePrint("level");
    }
}