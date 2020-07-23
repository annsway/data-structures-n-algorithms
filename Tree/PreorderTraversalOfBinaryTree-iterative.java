/**

Implement an iterative, pre-order traversal of a given binary tree, return the list of keys of each node in the tree as it is pre-order traversed.

Examples

        5

      /    \

    3        8

  /   \        \

1      4        11

Pre-order traversal is [5, 3, 1, 4, 8, 11]

 **/

public class Solution {
  public List<Integer> preOrder(TreeNode root) {
    // Write your solution here
    List<Integer> res = new ArrayList<>();
    if(root == null){
      return res; 
    }
    Deque<TreeNode> stack = new ArrayDeque<>();
    stack.offerFirst(root);
    while(!stack.isEmpty()){
      // update curr
      // curr为下一个要print出来的元素
      TreeNode curr = stack.pollFirst();
      if(curr.right != null){
        stack.offerFirst(curr.right); // 往stack上堆元素
      } 
      if(curr.left != null){
        stack.offerFirst(curr.left); // 往stack上堆元素
      }
      res.add(curr.key); 
    }
    return res; 
  }
}
