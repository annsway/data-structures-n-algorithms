/*
Key points: 
1. 用ArrayList来记录出现过的node。若为leaf node 且不等于target value，那么须remove该node from the arraylist. 
2. 叠加temp时，要从大(当前node的值)到小遍历。
3. The return type of the recrusion functiton is **boolean**. 
4. 需要一个boolean variable将每层recursive call的结果传上去
5. 当左子树不为空时，dfs
6. 当右子树不为空时，dfs

Given a binary tree in which each node contains an integer number. Determine if there exists a path (the path can only be from one node to itself or to any of its descendants), the sum of the numbers on the path is the given target number.

Examples

    5

  /    \

2      11

     /    \

    6     14

  /

 3

If target = 17, There exists a path 11 + 6, the sum of the path is target.

If target = 20, There exists a path 11 + 6 + 3, the sum of the path is target.

If target = 10, There does not exist any paths sum of which is target.

If target = 11, There exists a path only containing the node 11.
*/

public class Solution {
  public boolean exist(TreeNode root, int target) {
    // Write your solution here
    if (root == null) {
      return false; 
    }
    List<TreeNode> M = new ArrayList<>();
    return helper(root, target, M);
  }
  private boolean helper(TreeNode root, int target, List<TreeNode> M) {
    M.add(root);
    int temp = 0; 
    for (int i = M.size() - 1; i >= 0; i--) {
      temp += M.get(i).key;
      if (temp == target) {
        return true; 
      }
    }
    if (root.left != null && helper(root.left, target, M)) {
      return true; 
    }
    if (root.right != null && helper(root.right, target, M)) {
      return true; 
    }
    M.remove(root);
    return false; 
  }
}
