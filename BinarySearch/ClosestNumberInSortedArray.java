/**
Given a target integer T and an integer array A sorted in ascending order, find the index i in A such that A[i] is closest to T.

Assumptions

There can be duplicate elements in the array, and we can return any of the indices with same value.
Examples

A = {1, 2, 3}, T = 2, return 1
A = {1, 4, 6}, T = 3, return 1
A = {1, 4, 6}, T = 5, return 1 or 2
A = {1, 3, 3, 4}, T = 2, return 0 or 1 or 2
**/

public class Solution {
    public static int closest(int[] array, int target) {
        // Write your solution here
        if(array == null || array.length == 0){
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        
        // use binary search to pull the two elements that are closest to the target value
        while(left < right - 1){
            int mid = left + (right - left) / 2;
            if(array[mid] >= target){
                right = mid;
            } else {
                left = mid;
            }
        }
        if(Math.abs(array[left] - target) < Math.abs(array[right] - target)){
            return left;
        } else {
            return right;
        }
    }

    public static void main(String[] args){
        int[] arr = {3,4,5,6,6,12,16};
        System.out.println(closest(arr, 10));
    }
}

