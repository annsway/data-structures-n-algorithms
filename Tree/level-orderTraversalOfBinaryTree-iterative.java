/**

        5
       / \
    null   8

Output: [5, null, 8, null, null]

**/



public List<Integer> levelOrder(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    Queue<TreeNode> q = new ArrayDeque<>();
    q.offer(root);
    TreeNode nullTree = new TreeNode(-1);
    while(!q.isEmpty()){
        TreeNode curr = q.poll();
        if(curr == nullTree){
            res.add(null); // 手动加 null 到 arraylist
            continue;
        }
        res.add(curr.key);

        if(curr.left != null){
            q.offer(curr.left); 
        } else {
            q.offer(nullTree); // queue does not allow NULL 
        }

        if(curr.right != null){
            q.offer(curr.right);
        } else {
            q.offer(nullTree);
        }


    }
    return res;
}