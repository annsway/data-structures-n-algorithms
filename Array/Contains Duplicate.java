/*
Given an array of integers, find if the array contains any duplicates. 
Your function should return true if any value appears at least twice 
in the array, and it should return false if every element is distinct.
*/
public class Solution {
  public boolean containsDuplicate(int[] nums) {
    // Write your solution here
    int size = nums.length; 
    Map<Integer, Integer> countMap = new HashMap<>();
    for (int i = 0; i < size; i++) {
      countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) + 1);
    }
    for (Map.Entry<Integer, Integer> item : countMap.entrySet()) {
      if (item.getValue() >= 2) {
        return true; 
      }
    }
    return false; 
  }
}
