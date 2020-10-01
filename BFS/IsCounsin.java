/*
In a binary tree, two nodes are cousins of each other if they are at the same level and have different parents.

For example, in the following tree:

                     6

                  /     \

               3            5

            /     \      /     \

           7       8    1       2

7 and 1 are cousins.
3 and 5 are not cousins.
7 and 5 are not cousins.

Given a binary tree and two nodes, determine if the two nodes are cousins or not.

*/

public boolean isCousin (TreeNode root, TreeNode one, TreeNode two) {
    if (root == null || one == null || two == null) {
        return false;
    }
    Queue<TreeNode> q = new ArrayDeque<>();
    q.offer(root);
    int found = 0;
    while (!q.isEmpty()) {
        int len = q.size();
        for (int i = 0; i < len; i++) {
            TreeNode cur = q.poll();
            if (cur.left != null) {
                q.offer(cur.left);
            }
            if (cur.right != null) {
                q.offer(cur.right);
            }
            if (cur == one || cur == two) {
                found++;
            }
        }
        if (found == 2) {
            return true;
        }
        if (found == 1) {
            return false;
        }
    }
    return false;
}