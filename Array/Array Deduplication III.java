/*
Given a sorted integer array, remove duplicate elements. For each group of elements with the same value do not keep any of them. Do this in-place, using the left side of the original array and and maintain the relative order of the elements of the array. Return the array after deduplication.

Assumptions

The given array is not null
Examples

{1, 2, 2, 3, 3, 3} → {1}
*/
public class Solution {
  public int[] dedup(int[] array) {
    // Write your solution here
    if (array == null || array.length <= 1) {
      return array; 
    }
    int slow = 0; 
    boolean isDup = false; 
    for (int fast = 1; fast < array.length; fast++) {
      if (array[slow] == array[fast]) {
        isDup = true; 
      } else if (isDup == true) {
        array[slow] = array[fast];
        isDup = false; 
      } else if (array[slow] != array[fast]) {
        slow++;
        array[slow] = array[fast];
      }
    }
    return Arrays.copyOf(array, isDup == false ? slow + 1 : slow);
  }
  /*
  0 1 2 3 4
  1 2 2 3 3
  s
    f 
  */
}
