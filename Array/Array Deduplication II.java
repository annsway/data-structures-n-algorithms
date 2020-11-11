/*
Given a sorted integer array, remove duplicate elements. For each group of elements with the same value keep at most two of them. Do this in-place, using the left side of the original array and maintain the relative order of the elements of the array. Return the array after deduplication.

Assumptions

The given array is not null
Examples

{1, 2, 2, 3, 3, 3} → {1, 2, 2, 3, 3}
*/
/*
0  1  2  3  4  5  6
1, 2, 2, 3, 3, 4, 4
               s
                  f
*/
import java.util.Arrays;

public class Solution{
    public int[] dedup(int[] array) {
        // Assumption: the array is sorted
        if (array.length < 2) {
            return array;
        }
        int slow = 1;
        for (int fast = 2; fast < array.length; fast++) {
        	// array[slow - 1] == array[fast] implies
            // array[slow - 1] == array[fast] == array[slow]
            if (array[slow - 1] != array[fast]) {
                slow++;
                array[slow] = array[fast];
            }
        }
        return Arrays.copyOf(array, slow + 1);
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] array = {1, 2, 2, 3, 3, 3, 4};
        System.out.println(Arrays.toString(sol.dedup(array)));
    }
}



