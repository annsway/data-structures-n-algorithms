/*
Given two keys in a binary search tree, find their lowest common ancestor.

Assumptions

There is no parent pointer for the nodes in the binary search tree

There are no duplicate keys in the binary search tree

The given two nodes are guaranteed to be in the binary search tree

Examples

        5

      /   \

     2     12

   /  \      \

  1    3      14

The lowest common ancestor of 1 and 14 is 5

The lowest common ancestor of 1 and 3 is 2

经典的从下往上返回值。
分类讨论：
1. p, q 为直接隶属关系(base case)
	case 1: left == null && right == null return null 
	case 2 + 3: if one side is null and the other side is NOT null
2. p, q 不直接为隶属关系
	case 1: left == null && right == null (base case)
	case 2 + 3: either is null
	case 4: if both sides are NOT null, return current
*/

public class Solution {
	public TreeNode LCA(TreeNode p, TreeNode a, TreeNode b) {
		if (p == null || p == a || p == b) {
			return p; 
		}
		TreeNode left = LCA(p.left, a, b);
		TreeNode right = LCA(p.right, a, b);
		if (left != null && right != null) {
			return p; 
		}
		return left == null ? right : left; 
	}

}