/*
Find all pairs of elements in a given array that sum to the given target number. Return all the pairs of indices.

Assumptions

The given array is not null and has length of at least 2.

Examples

A = {1, 3, 2, 4}, target = 5, return [[0, 3], [1, 2]]

A = {1, 2, 2, 4}, target = 6, return [[1, 3], [2, 3]]


*/
import java.util.*;

public class Solution{
    public List<List<Integer>> allPairs(int[] array, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>(); // ***
        for (int i = 0; i < array.length; i++) {
            List<Integer> pairs = map.get(target - array[i]);
            if (pairs != null) {
                for (int j : pairs) { // loop through the list to add all the indices under the same number 
                    res.add(Arrays.asList(j, i));
                }
            }
            if (!map.containsKey(array[i])) {
                map.put(array[i], new ArrayList<>());
            }
            /** add index to the associated number; 
             * there might be multiple indicies under the same number**/
            map.get(array[i]).add(i); 
            
        }
        return res;
    }
    public static void main(String[] args) {
        int[] array = {1, 2, 2, 4};
        Solution sol = new Solution();
        System.out.println(sol.allPairs(array, 6));
    }

}

