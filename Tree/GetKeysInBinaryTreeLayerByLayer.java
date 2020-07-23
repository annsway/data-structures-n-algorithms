/**
 * public class TreeNode {
 *   public int key;
 *   public TreeNode left;
 *   public TreeNode right;
 *   public TreeNode(int key) {
 *     this.key = key;
 *   }
 * }
Get the list of list of keys in a given binary tree layer by layer. Each layer is represented by a list of keys and the keys are traversed from left to right.

Examples

        5

      /    \

    3        8

  /   \        \

 1     4        11

the result is [ [5], [3, 8], [1, 4, 11] ]
 
 */
public class Solution {
  public List<List<Integer>> layerByLayer(TreeNode root) {
    // Write your solution here
    List<List<Integer>> res = new ArrayList<>();
    if(root == null){
      return res; 
    }

    Deque<TreeNode> q = new ArrayDeque<>();
    q.offer(root);

    // 一个q代表一层level
    while(!q.isEmpty()){
      int currLevelSize = q.size(); // 每层level的元素个数都不同，用q.size()拿到
      List<Integer> currLevel = new ArrayList<>(); // level 必须在while loop里面，每层都要重新declare，才能清空上一层的元素
      
      // 作用一：遍历每层的元素
      // 作用二：为下一层level做准备
      for(int i=0; i<currLevelSize; i++){
        TreeNode curr = q.poll();
        currLevel.add(curr.key);

        if(curr.left != null){
          q.offer(curr.left); // 往q上加元素为下一level做准备，size不变
        }
        if(curr.right != null){
          q.offer(curr.right); // 往q上加元素为下一level做准备，size不变
        }
      }
      res.add(currLevel);
    }
    return res; 
  }
}
