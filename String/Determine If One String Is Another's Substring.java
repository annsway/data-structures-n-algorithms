/*
Determine if a small string is a substring of another large string.

Return the index of the first occurrence of the small string in the large string.

Return -1 if the small string is not a substring of the large string.

Assumptions

Both large and small are not null
If small is empty string, return 0
Examples

“ab” is a substring of “bcabc”, return 2
“bcd” is not a substring of “bcabc”, return -1
"" is substring of "abc", return 0
*/
public class Solution {
  public int strstr(String large, String small) {
    // Write your solution here
    if (large.length() < small.length()) {
      return -1; 
    }
    if (small.length() == 0) {
      return 0;
    } 
    for (int start = 0; start <= large.length() - small.length(); start++) {
      if (equals(large, start, small)) {
        return start; 
      }
    }
    return -1; 
  }
  private boolean equals(String large, int start, String small) {
    for (int j = 0; j < small.length(); j++) {
      if (large.charAt(j + start) != small.charAt(j)) {
        return false; 
      }
    }
    return true; 
  }
}
