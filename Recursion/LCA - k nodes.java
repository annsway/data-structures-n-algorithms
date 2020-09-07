import java.util.*;

public class SolBST {
    public TreeNode LCA(TreeNode p, Set<TreeNode> kNodes) {
        if (p == null || kNodes.contains(p)) {
            return p;
        }
        TreeNode left = LCA(p.left, kNodes);
        TreeNode right = LCA(p.right, kNodes);
        if (left != null && right != null) {
            return p;
        }
        return left == null ? right : left;
    }
/**         5
        /     \
       9       12
     /  \       \
    2   3        14     **/
    public static void main(String[] args) {
        // Create a binary search tree 
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(9);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(3);

        root.right = new TreeNode(12);
        root.right.right = new TreeNode(14);

        // test
        SolBST sol = new SolBST();
        Set<TreeNode> kNodes = new HashSet<>();
        kNodes.add(root.left.left);
        kNodes.add(root.left.right);
        kNodes.add(root.right.right);
        System.out.println(sol.LCA(root, kNodes).key);
    }
}