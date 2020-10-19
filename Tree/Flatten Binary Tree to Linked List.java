/*
Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:

   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
*/
import java.util.*;

public class SolBST {
    public TreeNode flatten(TreeNode root) {
        TreeNode[] prev = new TreeNode[1];
        helper(root, prev);
        return root;
    }
    private void helper(TreeNode root, TreeNode[] prev) {
        if (root == null) {
            return;
        }
        helper(root.right, prev);
        helper(root.left, prev);
        root.right = prev[0]; // 将right child 挂在root上，一路挂上去
        root.left = null;
        prev[0] = root;
    }
/**
 *     -5
 *   /    \
 * -2      -1
 *      /    \
 *     -6     -4
 **/
    public static void main(String[] args) {
        // Create a binary search tree 
        TreeNode root = new TreeNode(-5);

        root.left = new TreeNode(-2);

        root.right = new TreeNode(-1);
        root.right.left = new TreeNode(-6);
        root.right.right = new TreeNode(-4);

        // test
        SolBST sol = new SolBST();
        System.out.println(sol.flatten(root));
//        System.out.println(sol.layerByLayer(root));
    }
}