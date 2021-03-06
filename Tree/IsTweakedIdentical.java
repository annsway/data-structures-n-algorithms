/**

Determine whether two given binary trees are identical assuming any number of ‘tweak’s are allowed. A tweak is defined as a swap of the children of one node in the tree.

Examples

        5

      /    \

    3        8

  /   \

1      4

and

        5

      /    \

    8        3

           /   \

          1     4

the two binary trees are tweaked identical.

 * public class TreeNode {
 *   public int key;
 *   public TreeNode left;
 *   public TreeNode right;
 *   public TreeNode(int key) {
 *     this.key = key;
 *   }
 * }

题目意思

左右孩子不变 OR
左右孩子swap
TC

树高：log(n)
每层分四叉
AC: LL = O(n)
WC: balanced = O(n^2)

1 + 4 + 16 + 64 + ... + 2^logn
= (4^(logn) - 1) / (4 - 1) ...等比数列求和
= 2^2(logn)
= (2^logn)^2
= n^2

 */
    public boolean isTweakedIdentical(TreeNode one, TreeNode two) {
        if (one == null && two == null) {
            return true;
        } else if (one == null || two == null) {
            return false;
        } else if (one.key != two.key) {
            return false;
        }
        return // case 1
                isTweakedIdentical(one.left, two.left)
                && isTweakedIdentical(one.right, two.right)
               // case 2
                || isTweakedIdentical(one.left, two.right)
                && isTweakedIdentical(one.right, two.left);
    }
// case 1:     
//        5            5
//       / \          / \
//      3   6        3   6
//     / \          / \
//   1   4         1   4
    
// case 2:     
//        5            5
//       / \          / \
//      3   6        6   3
//     / \              / \
//   1   4             1   4
    
