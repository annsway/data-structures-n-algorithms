/**
 * public class TreeNode {
 *   public int key;
 *   public TreeNode left;
 *   public TreeNode right;
 *   public TreeNode(int key) {
 *     this.key = key;
 *   }
 * }
Get the list of keys in a given binary search tree in a given range[min, max] in ascending order, both min and max are inclusive.

Examples

        5

      /    \

    3        8

  /   \        \

 1     4        11

get the keys in [2, 5] in ascending order, result is  [3, 4, 5]

Corner Cases

What if there are no keys in the given range? Return an empty list in this case.
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
