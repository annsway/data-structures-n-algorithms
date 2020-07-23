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
  public TreeNode insert(TreeNode root, int target) {
    // Write your solution here
    if(root == null){
      return new TreeNode(target);
    }
    TreeNode curr = root; 
    TreeNode prev = null; 
    while(curr != null){
      prev = curr; 
      if(curr.key < target){
        curr = curr.right; 
      } else if(curr.key > target){
        curr = curr.left; 
      } else {
        return root; 
      }
    }
    if(prev.key < target) {
      prev.right = new TreeNode(target);
    } else if (prev.key > target) {
      prev.left = new TreeNode(target);
    }
    return root; 
  }
}
