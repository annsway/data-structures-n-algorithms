/*
Input: I love Google
Step 1: reverse the whole string 
elgooG evol I
Step 2: reverse each word 
Google love I
*/
public class Solution {
  public String reverseWords(String input) {
    // Write your solution here
    if (input == null) {
        return input;
    }
    char[] array = input.toCharArray();
    // Step 1: reverse the whole string
    reverse(array, 0, array.length - 1);
    int start = 0;
    for (int i = 0; i < array.length; i++) {
        if (array[i] == ' ') {
            reverse(array, start, i - 1);
            start = i + 1;
        }
        if (i == array.length - 1) {
            reverse(array, start, i);
        }
    }
    return new String(array);
  }
  private void reverse(char[] array, int start, int end) {
    while (start < end) {
        char temp = array[start];
        array[start] = array[end];
        array[end] = temp;
        start++;
        end--;
    }
  }

}
