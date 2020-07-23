// ref: https://www.youtube.com/watch?v=SS5Td7iz_0k


//Definition for a binary tree node.

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}

class Solution {

    public static TreeNode sortedArrayToBST(int[] nums) {

        return toBST(nums, 0, nums.length-1);
        
    }

    public static TreeNode toBST(int[] nums, int start, int end){

        TreeNode root;

        // start, end, and mid are indexes of the array nums
        if(start > end){ // start cannot equal to end 
            return null;
        }

        // find the midpoint of the index
        int mid = (int)(start+end)/2;

        // get the root by calling the defined class
        root = new TreeNode(nums[mid]);
        root.left = toBST(nums, start, mid-1);
        root.right = toBST(nums, mid+1, end);

        return root;

    }

    public static void main(String[] args) {
        sortedArrayToBST(new int[] {-10,-3,0,5,9});
    }


}