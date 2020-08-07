/**
Find all numbers that appear in both of two unsorted arrays.

Assumptions

Both of the two arrays are not null.
In any of the two arrays, there could be duplicate numbers.
Examples

A = {1, 2, 3, 2}, B = {3, 4, 2, 2, 2}, return [2, 2, 3] (there are both two 2s in A and B)

**/

public class Solution {
  public List<Integer> common(int[] a, int[] b) {
        // Write your solution here
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> countA = new HashMap<>();
        Map<Integer, Integer> countB = new HashMap<>();
        for (int num : a) {
            Integer count = countA.get(num);
            if (count != null) {
                countA.put(num, ++count); // must be ++count in order to update the count
            } else {
                countA.put(num, 1);
            }
        }
        for (int num : b) {
            Integer count = countB.get(num);
            if (count != null) {
                countB.put(num, ++count);
            } else {
                countB.put(num, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entryA : countA.entrySet()) {
            Integer countInB = countB.get(entryA.getKey()); // get the count in B if this value from A appears in B
            if (countInB != null) {
                int appear = Math.min(entryA.getValue(), countInB); // get the least count for common value in terms of duplicate 
                for (int i = 0; i < appear; i++) {
                  res.add(entryA.getKey());
                }
            }
        }
        Collections.sort(res);
        return res;
    }
}
