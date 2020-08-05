/**
解题：
1. return的是original root node!!! 改变的是root.right 和root.left（见recursive functions）。
2. 分类讨论. 
3. 难点：Case 4, 当target有左右子树时, rule of thumb：返回target右子树的最小节点

case 1: target has no left child, no right child 
 
case 2: target has left child, no right child 
    => replace target position with left child 

case 3: target has right child, no left child 
    => replace target position with right child 

**case 4.1: target has both children, the right child has no left child**
    => replace target position with right child 

**case 4.2: target has both children, the right child has left child**
    => find the smallest (left child) of the right child, replace the target with the smallest
    => replace the original smallest child position with its right child

**/
//        3
//       / \
//      2   8 (to delete) <-[9]
//         /  \
//        6    12
//            /  \
//           11   14
//          / |
//        [9] |
//          \ |
//           10

public class SolBST {
    public TreeNode deleteTree(TreeNode root, int target) {
        // Write your solution here
        if (root == null) {
            return null;
        }
        // base case
        if (root.key == target) {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else if (root.right.left == null) {
                root.right.left = root.left;
                return root.right;
            } else {
                TreeNode newRoot = smallest(root.right);
                newRoot.left = root.left;
                newRoot.right = root.right;
                return newRoot;
            }
        }
        // recursion
        if (root.key < target) {
            root.right = deleteTree(root.right, target); // 
        } else if (root.key > target) {
            root.left = deleteTree(root.left, target);
        }
        return root;
    }

    // we need to keep track of previous TreeNode
    private TreeNode smallest(TreeNode root) {
        while (root.left.left != null) {
            root = root.left;
        }
        TreeNode smallest = root.left;
        root.left = root.left.right; // 挂
        return smallest;
    }

    public static void main(String[] args) {
        // Create a binary search tree 
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(12);

        root.right.right.left = new TreeNode(11);
        root.right.right.right = new TreeNode(14);

        root.right.right.left.left = new TreeNode(9);
        root.right.right.left.left.right = new TreeNode(10);

        // test
        SolBST sol = new SolBST();
        System.out.println(sol.deleteTree(root, 8).key);

    }

}