/*
* Given a binary tree in which each node contains an int number.
Find the maximum possible sum from any leaf node to another leaf node.
The maximum sum path may or may not go through root.
Expected time complexity is O(n).

           -15
        /     \
       5       6
     /  \     / \
   -8    1   3   9
  / \             \
 2   6             0
                  / \
                 4   -1
                     /
                    10

res: 3 - 6 - 9 - 0 - -1 - 10

* */

import java.util.*;

public class SolBST {
    public int findMax(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int[] globalMax = new int[1]; // pass by value, otherwise globalMax cannot be changed
        globalMax[0] = Integer.MIN_VALUE;
        helper(root, globalMax);
        return globalMax[0];
    }
    private int helper(TreeNode root, int[] globalMax) {
        if (root == null) {
            return 0;
        }
        int leftMax = helper(root.left, globalMax);
        int rightMax = helper(root.right, globalMax);
        if (root.left != null && root.right != null) {
            globalMax[0] = Math.max(globalMax[0], leftMax + rightMax + root.key);
            return Math.max(leftMax, rightMax) + root.key;
        }

        return root.left == null ? rightMax + root.key : leftMax + root.key;

    }

    public static void main(String[] args) {
        // Create a binary search tree 
        TreeNode root = new TreeNode(-15);
        root.left = new TreeNode(5);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(-8);
        root.left.right = new TreeNode(1);
        root.left.left.left = new TreeNode(2);
        root.left.left.right = new TreeNode(6);


        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(9);
        root.right.right.right = new TreeNode(0);
        root.right.right.right.left = new TreeNode(4);
        root.right.right.right.right = new TreeNode(-1);
        root.right.right.right.right.left = new TreeNode(10);

        // test
        SolBST sol = new SolBST();
        System.out.println(sol.findMax(root));
    }

}
