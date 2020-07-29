/**
 * public class TreeNode {
 *   public int key;
 *   public TreeNode left;
 *   public TreeNode right;
 *   public TreeNode(int key) {
 *     this.key = key;
 *   }
 * }
  0  1  2  3  4  5 
 [1, 3, 4, 5, 8, 11]
 */
public class Solution {
  public List<Integer> getRange(TreeNode root, int min, int max) {
    // Write your solution here
    List<Integer> res = new ArrayList<>();
    if (root == null) {
      return res; 
    }
    inOrder(root, res, min, max);
    return res; 
  }

  private void inOrder(TreeNode root, List<Integer> res, int min, int max) {
    if (root == null) {
      return; 
    }
    if (root.key > min) {
      inOrder(root.left, res, min, max);
    }
    if (root.key >= min && root.key <= max) {
      res.add(root.key); 
    } 
    if (root.key < max) {
      inOrder(root.right, res, min, max);
    }
  } 
  
}
