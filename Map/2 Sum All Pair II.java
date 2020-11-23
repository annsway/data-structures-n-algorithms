/*
Find all pairs of elements in a given array that sum to the pair the given target number. Return all the distinct pairs of values.

Assumptions

The given array is not null and has length of at least 2
The order of the values in the pair does not matter
Examples

A = {2, 1, 3, 2, 4, 3, 4, 2}, target = 6, return [[2, 4], [3, 3]]
*/
public class Solution {
  public List<List<Integer>> allPairs(int[] array, int target) {
    // Write your solution here
    List<List<Integer>> res = new ArrayList<>();
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < array.length; i++) {
      int remainder = target - array[i]; 
      if (map.containsKey(remainder) && map.get(remainder) == 0) {
        res.add(Arrays.asList(remainder, array[i]));
        map.put(array[i], 1);
        map.put(remainder, 1);
      }
      if (!map.containsKey(array[i])) {
        map.put(array[i], 0);
      }
    }
    return res; 
  }
}
