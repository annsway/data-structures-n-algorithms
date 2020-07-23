public class Solution {
  public TreeNode insert(TreeNode root, int key) {
    // Write your solution here
    if(root == null){
      return new TreeNode(key);
    }

    // Recursion - node要一路挂上去，有写操作(. deference)
    if(root.key > key){
      root.left = insert(root.left, key);
    } else if(root.key < key) {
      root.right = insert(root.right, key);
    }

    return root; 
    
  }
}
