/*
Get the list of keys in a given binary tree layer by layer in zig-zag order.

Examples

        5

      /    \

    3        8

  /   \        \

 1     4        11

the result is [5, 3, 8, 11, 4, 1]

Corner Cases

What if the binary tree is null? Return an empty list in this case.

*/
public class SolBST {
    public List<Integer> zigZag(TreeNode root) {
        // Write your solution here
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        int layer = 0; // represents the even rows
        while (!q.isEmpty()) {
            int curSize = q.size();
            for (int i = 0; i < curSize; i++) {
                if (layer == 0) {
                    TreeNode cur = q.pollLast(); // the bottom element of the stack ...x]
                    res.add(cur.key);
                    // at even layer: right to left
                    if (cur.right != null) {
                        q.offerFirst(cur.right);
                    }
                    if (cur.left != null) {
                        q.offerFirst(cur.left);
                    }
                } else if (layer == 1) {
                    TreeNode cur = q.pollFirst();
                    res.add(cur.key);
                    // at odd layer: left to right
                    if (cur.left != null) {
                        q.offerLast(cur.left);
                    }
                    if (cur.right != null) {
                        q.offerLast(cur.right);
                    }
                }
            }
            layer = 1 - layer;
        }
        System.out.println(res);
        return res;
    }
/*   q = first [] last
     cur = 9
     res = {-5, -2, -1, -4, -6, 9}
     layer = 0
     curSize = 3 0 1 2
     */
/**
 *      -5
 *    /    \
 *  -2      -1
 *  /    /    \
 * 9    -6     -4
 **/
    public static void main(String[] args) {
        // Create a binary search tree 
        TreeNode root = new TreeNode(-5);

        root.left = new TreeNode(-2);
        root.left.left = new TreeNode(9);

        root.right = new TreeNode(-1);
        root.right.right = new TreeNode(-4);
        root.right.left = new TreeNode(-6);


        // test
        SolBST sol = new SolBST();
        sol.zigZag(root);
        sol.layerByLayer(root);
    }
}