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
  public boolean isCompleted(TreeNode root) {
    // Write your solution here
    if(root == null){
      return true; 
    }
    // Data structure: FIFO queue
    Deque<TreeNode> queue = new ArrayDeque<>();
    boolean firstBubble = false; // 一旦为true，则应无左右childe nodes
    queue.offer(root);
    // Expand 
    // Generate: 
    //  - when the flag is off, if the left child OR the right child is null, then set the flag = true
    //  - when the flag is on, if the left child OR the right child is NOT null, then return false 
    //    (因为这样说明either同层出现左bubble or 两层同时出现bubbles)
    while(!queue.isEmpty()){
      TreeNode curr = queue.poll();
      if(curr.left == null){
        firstBubble = true;
      } else if (firstBubble) { // e.g. {"1","2","#","3"} 左不空，右空两次，firstBubble = true 被第一个右空设置
        return false; 
      } else {
        queue.offer(curr.left);
      }

      if(curr.right == null){
        firstBubble = true; 
      } else if (firstBubble) { // e.g. {"3","#","2"} 左空右不空，同层出现bubble
        return false; 
      } else {
        queue.offer(curr.right);
      }
    }
    return true; 
  }

}
