/**
Check if a given binary tree is symmetric.

Examples

        5

      /    \

    3        3

  /   \    /   \

1      4  4      1

is symmetric.

        5

      /    \

    3        3

  /   \    /   \

1      4  1      4

is not symmetric.

Corner Cases

What if the binary tree is null? Return true in this case.
**/
public boolean isSymmetric(TreeNode root) {
    // Write your solution here
    if (root == null) {
        return true;
    }
    return helper(root.left, root.right);
}
public boolean helper(TreeNode one, TreeNode two) {
    if (one == null && two == null ) {
        return true;
    } else if (one == null || two == null) {
        return false;
    } else if (one.key != two.key) {
        return false;
    }
    return helper(one.left, two.right) // outer path 
            && helper(one.right, two.left); // inner path 
}