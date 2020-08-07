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
// Special Pre Order: [5, 8, 11, 3, 4, 1]
// Reverse it to Post Order: [1, 4, 3, 11, 8, 5] 

public class Solution {
  public List<Integer> postOrder(TreeNode root) {
    // Write your solution here
    List<Integer> res = new ArrayList<>();
    if (root == null) {
      return res; 
    }
    Deque<TreeNode> stack = new ArrayDeque<>();
    stack.offerFirst(root);
    while (!stack.isEmpty()) {
      TreeNode cur = stack.pollFirst(); 
      if (cur.left != null) {
        stack.offerFirst(cur.left);
      }
      if (cur.right != null) {
        stack.offerFirst(cur.right);
      }
      res.add(cur.key);
    }
    Collections.reverse(res);
    return res; 
  }
}

