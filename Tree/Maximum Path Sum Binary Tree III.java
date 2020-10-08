/*
Given a binary tree in which each node contains an integer number. Find the maximum possible subpath sum(both the starting and ending node of the subpath should be on the same path from root to one of the leaf nodes, and the subpath is allowed to contain only one node).

Assumptions

The root of given binary tree is not null
Examples

   -5

  /    \

2      11

     /    \

    6     14

           /

        -3

The maximum path sum is 11 + 14 = 25
*/
public class SolBST {
    public int maxPathSum(TreeNode root) {
        // Write your solution here
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
        int temp = Math.max(0, Math.max(leftMax, rightMax)) + root.key;
        max[0] = Math.max(max[0], temp);
        return temp;
    }
/**
 *    -5
 *   /    \
 * -2      -11
 *      /    \
 *     -6     -14
 *            /
 *         -3
 **/
    public static void main(String[] args) {
        // Create a binary search tree 
        TreeNode root = new TreeNode(-5);

        root.left = new TreeNode(-2);

        root.right = new TreeNode(-11);
        root.right.left = new TreeNode(-6);
        root.right.right = new TreeNode(-14);
        root.right.right.left = new TreeNode(-3);

        // test
        SolBST sol = new SolBST();
        System.out.println(sol.maxPathSum(root));;
//        System.out.println(sol.layerByLayer(root));
    }
}