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