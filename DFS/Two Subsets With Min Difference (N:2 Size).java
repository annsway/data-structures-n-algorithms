/*
Given a set of n integers, divide the set in two subsets of n/2 sizes each such that the difference of the sum of two subsets is as minimum as possible.

Return the minimum difference(absolute value).

Assumptions:

The given integer array is not null and it has length of >= 2.
Examples:

{1, 3, 2} can be divided into {1, 2} and {3}, the minimum difference is 0

*/
public class Solution{
    public int minDifference(int[] array) {
        // Write your solution here
        int[] globalMin = new int[1];
        int total = 0;
        for (int num : array) {
            total += num;
        }
        globalMin[0] = Integer.MAX_VALUE;
        dfs(array, globalMin, 0, 0, total, 0);
        return globalMin[0];
    }
    private void dfs(int[] array, int[] globalMin, int level, int curSum, int total, int count) {
        // base case
        if (level == array.length) {
            if (count == array.length / 2) {
                globalMin[0] = Math.min(globalMin[0], Math.abs(curSum - (total - curSum)));
            }
            return;
        }
        curSum += array[level];
        dfs(array, globalMin, level + 1, curSum, total, ++count);
        curSum -=array[level];
        dfs(array, globalMin, level + 1, curSum, total, --count);
    }
    /*           /    | | \
  L0 {5}      {5}
  L1 {-2}  {5,-2}     {-2}
  L2 {-10}   {5,-10}    {-2, -10}
  L3 {3}       {5,3}       {-2, 3}
    */

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] array = {5,-2,-10,3};
        // Expected: {5, -10} {-2, 3}
        // abs({-5} - {1}) = 6
        // total = -4
        System.out.println(sol.minDifference(array));
    }
}

