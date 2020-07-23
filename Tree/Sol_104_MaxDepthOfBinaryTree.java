import javax.swing.tree.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Sol_104_MaxDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {

        if(root == null){
            return 0;
        }

        // recursion
        return 1+Math.max(maxDepth(root.getChildAt(0)), maxDepth(root.getChildAt(1)));

    }
}
