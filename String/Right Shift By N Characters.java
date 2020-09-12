/*
Right shift a given string by n characters.

Assumptions

The given string is not null.
n >= 0.

Example: 
  i: 012
    abc -> 
  1) cab -> 
  2) bca ->
  3) abc ->
  4) cab   
*/

public class Solution {
  public String rightShift(String input, int n) {
  /* My Idea: Find the remainder of n in respect to input.length to calculate the final moves 
    (if an element moves to the original point (remainder = 0), then it means no move)
  */
    if (input == null || input.length() == 0) {
      return new String("");
    }
    char[] array = new char[input.length()];
    char[] inputArr = input.toCharArray();
    int move = n % array.length;
    for (int i = 0; i < array.length; i++) {
        int pos = i + move;
        if (pos >= array.length) {
            pos = pos % array.length;
        }
        array[pos] = inputArr[i];
    }
    return new String(array);
  }
}
