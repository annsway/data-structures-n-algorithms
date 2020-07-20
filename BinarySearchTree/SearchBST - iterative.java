public class Solution {
  public TreeNode search(TreeNode root, int key) {
    // Write your solution here
    if(root == null){
      return null; 
    }
    while(root != null){
      if(root.key == key){
        return root; 
      } else if(root.key < key){
        root = root.right; 
      } else {
        root = root.left; 
      }
    }
    return null; 
  }
}
