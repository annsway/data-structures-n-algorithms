/*
Key points: 
  1. Recursive function returns leftNum + rightNum + 1 (itself), whereas leftNum
  only looks the left subtree. (So, you should use a variable to store leftNum, 
  while return the whole subtree

*/
/**
 * public class TreeNodeLeft {
 *   public int key;
 *   public TreeNodeLeft left;
 *   public TreeNodeLeft right;
 *   public int numNodesLeft;
 *   public TreeNodeLeft(int key) {
 *     this.key = key;
 *   }
 * }
 */
public class Solution {
  public void numNodesLeft(TreeNodeLeft root) {
    // Write your solution here
    if (root == null) {
      return;
    }
    helper(root);
  }
  private int helper(TreeNodeLeft root) {
    // base case 
    if (root == null) {
      return 0;
    }
    int leftNum = helper(root.left); // # of nodes of root.left
    int rightNum = helper(root.right); // # of nodes of root.right
    root.numNodesLeft = leftNum; 
    return leftNum + rightNum + 1; // + itself: # of nodes of root
  }
}