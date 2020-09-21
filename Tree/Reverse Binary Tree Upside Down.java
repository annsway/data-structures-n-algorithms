/*
Given a binary tree where all the right nodes are leaf nodes, flip it upside down and turn it into a tree with left leaf nodes as the root.

Examples

        1

      /    \

    2        5

  /   \

3      4

is reversed to

        3

      /    \

    2        4

  /   \

1      5
*/

public TreeNode reverse(TreeNode root) {
    if (root == null || root.left == null) {
        return root;
    }
    TreeNode newHead = reverse(root.left);
    // newHead and root.left.left are pointing to the same TreeNode, which is the new Head 
    root.left.left = root; // Link the new left node to the newHead
    root.left.right = root.right; // Link the new left node to the newHead
    root.left = null;
    root.right = null;
    return newHead; // Note: must pass newHead up layer by layer 
}

/**    5
    /     \
   3       12
            \
            14     **/
public static void main(String[] args) {
    // Create a binary search tree 
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(3);
//        root.left.left = new TreeNode(2);
//        root.left.right = new TreeNode(4);

    root.right = new TreeNode(12);
    root.right.right = new TreeNode(14);

    // test
    SolBST sol = new SolBST();
//        System.out.println("in order: " + sol.inOrder(root));
    System.out.println(sol.reverse(root).key);
}
