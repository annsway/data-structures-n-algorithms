import java.util.*;

public class SolBST {
    // delete nodes with only 1 child.
    public TreeNode delete(TreeNode root) {
        if (root == null) {
            return null;
        }
        // Sub-problems
        root.left = delete(root.left);
        root.right = delete(root.right);
        // What to do on the current layer
        if (root.left == null && root.right == null || root.left != null && root.right != null) {
            return root;
        }
        return root.left == null ? root.right : root.left;
    }

/** Before:
           -15
        /     \
       5       6
        \     / \
        1   3    9

     After:
        -15
      /     \
     1       6
            / \
           3   9
 **/

    public static void main(String[] args) {
        // Create a binary search tree 
        TreeNode root = new TreeNode(-15);
        root.left = new TreeNode(5);
        root.right = new TreeNode(6);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(9);

        // test
        SolBST sol = new SolBST();

        System.out.println(sol.layerByLayer(root));
        System.out.println(sol.delete(root).key);
        System.out.println(sol.layerByLayer(root));
    }

}
