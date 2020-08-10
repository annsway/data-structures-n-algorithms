/*
Given a string, find the longest substring without any repeating characters and return the length of it. 
The input string is guaranteed to be not null.

For example, the longest substring without repeating letters for "bcdfbd" is "bcdf", we should return 4 in this case.
*/
public class Solution {
  public int longest(String input) {
    // Write your solution here
    int slow = 0; 
    int fast = 0; 
    int longest = 0;
    Set<Character> set = new HashSet<>(); 
    // [slow, fast) or [slow, fast - 1] is the sliding window 
    // when fast finds a duplicate, fast will wait there, let slow++
    while (fast < input.length()) {
      if (set.contains(input.charAt(fast))) { 
        set.remove(input.charAt(slow++)); 
        // move slow pointer till the duplicate is found and removed 
        // this will update the (fast - slow) below, and compare it to the longest
      } else {
        set.add(input.charAt(fast++));
        longest = Math.max(longest, fast - slow);
      }
    }
    return longest; 
  }
}
