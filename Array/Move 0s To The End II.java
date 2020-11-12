/*
Given an array of integers, move all the 0s to the right end of the array.

The relative order of the elements in the original array need to be maintained.

Assumptions:

The given array is not null.
Examples:

{1} --> {1}
{1, 0, 3, 0, 1} --> {1, 3, 1, 0, 0}
*/
public class Solution {
  public int[] moveZero(int[] array) {
    // Write your solution here
    if (array == null || array.length <= 1) {
      return array; 
    }
    int slow = 0; 
    for (int fast = 0; fast < array.length; fast++) {
      if (array[fast] != 0) {
        array[slow] = array[fast];
        slow++;
      } 
    }
    for (int i = slow; i < array.length; i++) {
      array[i] = 0;
    }
    return array; 
  }
}
/*
 1 2
   s
   f
*/