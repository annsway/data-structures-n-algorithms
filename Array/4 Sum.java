/*Determine if there exists a set of four elements in a given array that sum to the given target number.

Assumptions

The given array is not null and has length of at least 4
Examples

A = {1, 2, 2, 3, 4}, target = 9, return true(1 + 2 + 2 + 4 = 9)

A = {1, 2, 2, 3, 4}, target = 12, return false

Method 1: O(n^3)*/
public class Solution {
  public boolean exist(int[] array, int target) {
    // Write your solution here
    for (int i = 0; i < array.length - 3; i++) {
      for (int j = array.length - 1; j > i + 2; j--) {
        int remainder = target - (array[i] + array[j]);
        int left = i + 1; 
        int right = j - 1; 
        while (left < right) {
          int sum = array[left] + array[right];
          if (sum == remainder) {
            return true; 
          } else if (sum < remainder) {
            left++;
          } else {
            right--;
          }
        }
      }
    }
    return false; 
  }
}

/*Method 2: O(nlogn)*/
