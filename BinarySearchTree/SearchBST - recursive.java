public TreeNode search(TreeNode root, int key) {
    if(root == null || root.key == key){
        return root;
    }
    return root.key < key ? search(root.right, key) : search(root.left, key);
}
