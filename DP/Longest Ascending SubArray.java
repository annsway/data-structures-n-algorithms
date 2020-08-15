/*
Given an unsorted array, find the length of the longest subarray in which the numbers are in ascending order.

Assumptions

The given array is not null
Examples

{7, 2, 3, 1, 5, 8, 9, 6}, longest ascending subarray is {1, 5, 8, 9}, length is 4.

{1, 2, 3, 3, 4, 4, 5}, longest ascending subarray is {1, 2, 3}, length is 3.
*/

public class Solution{
    public int longest(int[] array) {
        // Write your solution here
        if (array.length <= 1) {
            return 0;
        }
        int max = 1;
        int count = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] < array[i]) {
                count++;
                max = Math.max(count, max);
            } else {
                count = 1;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.longest(new int[]{1, 2, 3, 1, 2, 3, 4, 4, 5}));;
    }

}


