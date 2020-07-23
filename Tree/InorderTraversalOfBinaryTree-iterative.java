/**
Implement an iterative, in-order traversal of a given binary tree, return the list of keys of each node in the tree as it is in-order traversed.

Examples

        5

      /    \

    3        8

  /   \        \

1      4        11

In-order traversal is [1, 3, 4, 5, 8, 11]
**/

public List<Integer> inOrder(TreeNode root){
    List<Integer> inorder = new ArrayList<>();
    Deque<TreeNode> stack = new LinkedList<>();
    TreeNode curr = root;
    while(curr != null || !stack.isEmpty()){
        if(curr != null){
            // 作用一：找到 leftmost node，并把 root 和*所有* left nodes push onto the stack
            // 作用二：当 left 和 root 完成 traverse，将right node push onto the stack
            stack.offerFirst(curr);
            curr = curr.left;
        } else {
            curr = stack.pollFirst(); // .pollFirst() 后，接下来那个元素即为上一节点(root)
            inorder.add(curr.key);
            curr = curr.right; // 当 left 和 root 完成traverse，找right node，
                               // 下一步执行 if 内操作，将 right node 放在stack最上面，下一个出栈
        }
    }
    return inorder;

}