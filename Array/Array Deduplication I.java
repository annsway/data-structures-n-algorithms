/*
Given a sorted integer array, remove duplicate elements. For each group of elements with the same value keep only one of them. Do this in-place, using the left side of the original array and maintain the relative order of the elements of the array. Return the array after deduplication.

Assumptions

The array is not null
Examples

{1, 2, 2, 3, 3, 3} → {1, 2, 3}
*/

public class Solution {
    public int[] dedup(int[] array) {
        // Write your solution here
        if (array == null || array.length <= 1) {
            return array;
        }
        int slow = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[slow] != array[i]) {
                slow++;
                array[slow] = array[i];
            }
        }
        return Arrays.copyOfRange(array, 0, slow + 1); // slow + 1 in order to include array[slow]
    }
}

