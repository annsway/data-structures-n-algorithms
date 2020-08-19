/*
Given a string, a partitioning of the string is a palindrome partitioning if every substring of the partition is a palindrome. Determine the fewest cuts needed for a palindrome partitioning of a given string.

Assumptions

The given string is not null
Examples

“a | babbbab | bab | aba” is a palindrome partitioning of “ababbbabbababa”.

The minimum number of cuts needed is 3.

*/
public class Solution {
    public int minCuts(String data) {
        // Write your solution here
        char[] input = data.toCharArray();
        if (input.length <= 1) {
            return 0;
        }
        int[] M = new int[input.length];
        M[0] = 0;
        for (int i = 1; i < input.length; i++) {
            M[i] = M[i - 1] + 1; // 往前走一步，切第一刀（prev + 1）
            for (int j = i - 1; j >= 0; j--) { // Find the next palindrome looking forward
                if (isPalindrome(input, j, i)) {
                    if(j == 0) {
                        M[i] = 0; // 当j到i整一个是palidrome 
                    } else {
                        M[i] = Math.min(M[i], M[j - 1] + 1); // 切
                    }
                }
            }
        }
        return M[input.length-1];
    }
    private boolean isPalindrome(char[] input, int start, int end) {
      if (input.length <= 1) {
          return true;
      }
      while (start < end) {
          if (input[start] != input[end]) {
              return false;
          }
          start++;
          end--;
      }
      return true;
    }
}
