public boolean find(TreeNode root, int val) {
    if (root == null) {
        return false;
    }
    if (root. val == val) 
        return true;
    
    if (root.val > val) 
        return find(root.left, val);
   
    return find(root.right, val);
}

//不写else 是因为java需要有一个return，如果放在else里面了，就会报错