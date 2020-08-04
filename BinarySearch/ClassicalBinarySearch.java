/**
Given a target integer T and an integer array A sorted in ascending order, find the index i such that A[i] == T or return -1 if there is no such index.

Assumptions

There can be duplicate elements in the array, and you can return any of the indices i such that A[i] == T.
Examples

A = {1, 2, 3, 4, 5}, T = 3, return 2
A = {1, 2, 3, 4, 5}, T = 6, return -1
A = {1, 2, 2, 2, 3, 4}, T = 2, return 1 or 2 or 3
**/

public class Solution {
  public int binarySearch(int[] array, int target) {
    // Write your solution here
    if(array == null || array.length == 0){
      return -1;
    }
    int left = 0;
    int right = array.length - 1; 
    while(left <= right){ // 必须是<=， 否则出第一次直接找到target外，其余情况都无法找到，因为最后一轮搜索范围只剩一个元素时，left = right，必须要进入while来判断是否为target
      int mid = left + (right - left) / 2;
      if(array[mid] == target){
        return mid;
      } else if(array[mid] > target){
        right = mid - 1; // 必须-1: 当target比array里最小的元素小时，若right = mid，那么最后一次 right = left, 会进入死循环
      } else if(array[mid] < target){
        left = mid + 1; // 必须+1：当target比array里最大的元素大时，若left = mid，那么最后一次 left = right, 会进入死循环
      }
    }
    return -1;
  }
}