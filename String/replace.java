/*
Given an original string input, and two strings S and T, replace all occurrences of S in input with T.

Assumptions

input, S and T are not null, S is not empty string
Examples

input = "appledogapple", S = "apple", T = "cat", input becomes "catdogcat"
input = "dodododo", S = "dod", T = "a", input becomes "aoao"

---------------------------------
Test case: 
  0123456789012
  appledogapple
  f
  m
---------------------------------
  String API: 
**public int indexOf(String str, int fromIndex)**
- returns an int value, representing the index of the first occurrence of the character in the string, or -1 if it never occurs

**append(CharSequence s, int start, int end)**
- Appends a subsequence of the specified CharSequence to this sequence.
- CharSequence is a String
*/

public class Solution {
  public String replace(String input, String source, String target) {
    // Write your solution here
    StringBuilder sb = new StringBuilder();
    int fromIndex = 0; 
    int matchIndex = input.indexOf(source, fromIndex); 
    // matchIndex: the starting index of the first source found
    while (matchIndex != -1) { // ***
      sb.append(input, fromIndex, matchIndex).append(target); // ***
      fromIndex = matchIndex + source.length(); // ***
      matchIndex = input.indexOf(source, fromIndex);
    }
    sb.append(input, fromIndex, input.length());
    return sb.toString();
  }
}

