/**
 * public class TreeNode {
 *   public int key;
 *   public TreeNode left;
 *   public TreeNode right;
 *   public TreeNode(int key) {
 *     this.key = key;
 *   }
 * }

1. return的是deleted node 的子节点，而非整个BST的root。
2. 不用detach deleted node from the BST, 只需返回其子节点即可。
3. 分类讨论. Rule of thumbs：返回target左子树的最小节点
5. 难点：Case 4 - 当target有左右子树时
    // case 1: target has no left child, no right child 
    // case 2: target has left child, no right child 
    //        => replace target position with left child 
    // case 3: target has right child, no left child 
    //        => replace target position with right child 
    // case 4.1: target has both children, the right child has no left child 
    //        => replace target position with right child 
    // case 4.2: target has both children, the right child has left child  
    //        => find the smallest left child, replace the target with it
    //        => replace the left child position with its right child


 */
public class Solution {
  public TreeNode deleteTree(TreeNode root, int key) {
    // Write your solution here
    if (root == null) {
      return null; 
    }
    if (key == root.key) {
      if (root.left == null) {
        return root.right; 
      } else if (root.right == null) {
        return root.left; 
      } else if (root.right.left == null) { // case 4.1
        root.right.left = root.left; 
        return root.right; 
      } else { // case 4.2
        TreeNode newRoot = deleteSmallest(root.right);
        newRoot.left = root.left; 
        newRoot.right = root.right; 
        return newRoot; 
      }
    }
    if (key < root.key) {
      root.left = deleteTree(root.left, key); // recursion 
    } else if (key > root.key) {
      root.right = deleteTree(root.right, key);
    }
    return root; 
  }

  private TreeNode deleteSmallest(TreeNode root) {
    while (root.left.left != null) {
      root = root.left; 
    }
    TreeNode smallest = root.left; // 记录最小节点
    root.left = root.left.right; // detach最小节点，将最小节点的右孩子挂到母节点
    return smallest; 
  }
}
