public int maxPathSumLeafToRoot(TreeNode root) {
    // Write your solution here
    if (root == null) {
        return 0;
    }
    return helper(root);
}
private int helper(TreeNode root) {
    if (root == null) {
        return 0;
    }
    int leftMax = helper(root.left);
    int rightMax = helper(root.right);
    if (root.left != null && root.right != null) {
        return root.key + Math.max(leftMax, rightMax);
    } else if (leftMax == 0 && rightMax == 0) {
        return root.key;
    }
    return leftMax == 0 ? root.key + rightMax : root.key + leftMax;
}
/**
         -10
      /     \
    -16     12
   /   \       \
 -8    -15     -12
/  \    / \
-2    3 -13  11
**/
public static void main(String[] args) {
    // Create a binary search tree 
    TreeNode root = new TreeNode(-10);
    root.left = new TreeNode(-16);
    root.left.left = new TreeNode(-8);
    root.left.left.left = new TreeNode(-2);
    root.left.left.right = new TreeNode(3);

    root.left.right = new TreeNode(-15);
    root.left.right.left = new TreeNode(-13);
    root.left.right.right = new TreeNode(11);

    root.right = new TreeNode(12);
    root.right.right = new TreeNode(-12);

    // test
    SolBST sol = new SolBST();
//        System.out.println("in order: " + sol.inOrder(root));
    System.out.println(sol.maxPathSumLeafToRoot(root));
//        System.out.println(sol.layerByLayer(root));
}
