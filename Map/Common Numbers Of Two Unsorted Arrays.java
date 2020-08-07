/**
Common Numbers Of Two Unsorted Arrays.java

Find all numbers that appear in both of the two unsorted arrays, return the common numbers in increasing order.

Assumptions

Both arrays are not null.
There are no duplicate numbers in each of the two arrays respectively.
Exmaples

A = {1, 2, 3}, B = {3, 1, 4}, return [1, 3]
A = {}, B = {3, 1, 4}, return []

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
                countA.put(num, count++);
            } else {
                countA.put(num, 1);
            }
        }
        for (int num : b) {
            Integer count = countB.get(num);
            if (count != null) {
                countB.put(num, count++);
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
