/**
 * public class TreeNode {
 *   public int key;
 *   public TreeNode left;
 *   public TreeNode right;
 *   public TreeNode(int key) {
 *     this.key = key;
 *   }
 * }
 */
public class Solution {
  public boolean isBST(TreeNode root) {
    // Write your solution here
    if (root == null) {
      return true; 
    }
    return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE); // 要有一个range才能让子树的每一个node都被check到
  }
  private boolean isBST(TreeNode root, int min, int max) {
    if (root == null) { // 必须走到最后一层
      return true; 
    }
    if (root.key <= min || root.key >= max) { // 注: 这里是root
      return false;
    }
    return isBST(root.left, min, root.key) && isBST(root.right, root.key, max);
  }
}
