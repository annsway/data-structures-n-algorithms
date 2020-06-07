// Ref: https://leetcode.com/explore/learn/card/binary-search/138/background/1038/
// Given a sorted (in ascending order) integer array nums of n elements and a target value, write a function to search target in nums. If target exists, then return its index, otherwise return -1.

// My implementation of binary search 

class Solution {

    public static int binarySearch(int[] nums, int target) {

        int pivot, left=0, right=nums.length-1;

        while(left <= right){
            pivot = (left+right)/2; // pivot is the midpoint between left and right; will be updated in every round
            if(nums[pivot]==target){
                // System.out.println("Step into pivot: "+pivot);
                return pivot;
            }
            else if(target>nums[left]){
                left++;
                // System.out.println("Step into left: "+left);
            }
            else if(target<=nums[right]){
                right--;
                // System.out.println("Step into right: "+right);
            }

        }


        return -1;
    }

    public static void main(String[] args) {
        int[] intput={-1, 0, 5};
        System.out.println(binarySearch(intput, -1));
    }


}