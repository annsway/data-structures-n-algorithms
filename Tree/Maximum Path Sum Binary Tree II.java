public int maxPathSum(TreeNode root) {
    // Write your solution here
    if (root == null) {
        return 0;
    }
    int[] max = {Integer.MIN_VALUE};
    helper(root, max);
    return max[0];
}
private int helper(TreeNode root, int[] max) {
    if (root == null) {
        return 0;
    }
    int leftMax = helper(root.left, max);
    int rightMax = helper(root.right, max);
    leftMax = leftMax < 0 ? 0 : leftMax; // 如果子树为负，则不必加入max，即返回root本身
    rightMax = rightMax < 0 ? 0 : rightMax;
    max[0] = Math.max(max[0], root.key + leftMax + rightMax);
    return root.key + Math.max(leftMax, rightMax);
}
/**
       -3
      /
    -5
   /  \
 -10   4
      / \
    -1  -2
**/
public static void main(String[] args) {
    // Create a binary search tree 
    TreeNode root = new TreeNode(-3);
    root.left = new TreeNode(-5);
    root.left.left = new TreeNode(-10);
    root.left.right = new TreeNode(4);
    root.left.right.left = new TreeNode(-1);
    root.left.right.right = new TreeNode(-2);

//        root.right = new TreeNode(12);
//        root.right.right = new TreeNode(14);

    // test
    SolBST sol = new SolBST();
//        System.out.println("in order: " + sol.inOrder(root));
    System.out.println(sol.maxPathSum(root));
//        System.out.println(sol.layerByLayer(root));
}
