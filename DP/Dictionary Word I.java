/*
Given a word and a dictionary, determine if it can be composed by concatenating words from the given dictionary.

Assumptions

The given word is not null and is not empty
The given dictionary is not null and is not empty and all the words in the dictionary are not null or empty
Examples

Dictionary: {“bob”, “cat”, “rob”}

Word: “robob” return false

Word: “robcatbob” return true since it can be composed by "rob", "cat", "bob"
*/

public class Solution {
  public boolean canBreak(String input, String[] dict) {
      // Write your solution here
      boolean[] M = new boolean[input.length() + 1];
      M[0] = true; 
      Set<String> set = toSet(dict);
      for (int i = 1; i < M.length; i++) {
          for (int j = 0; j < i; j++) {
              if (set.contains(input.substring(j, i)) && M[j]) {
                  M[i] = true;
                  break;
              }
          }
      }
      return M[input.length()];
  }
  private Set<String> toSet(String[] input) {
      Set<String> res = new HashSet<>();
      for (int i = 0; i < input.length; i++) {
          res.add(input[i]);
      }
      return res;
  }
}
