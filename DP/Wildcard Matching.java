/*
Given two strings where first string is a normal string and second string may contain wild card characters. Write a function that returns true if the two strings match. The following are allowed wildcard characters in first string. 
* --> Matches with 0 or more instances of any character or set of characters.
? --> Matches with any one character.

Assumptions:

The two strings are both not null.
Assume there is no more than one '*' adjacent to each other.
Examples:

input = "abc", pattern = "?*", return true.
*/
public class Solution{
    public boolean match(String input, String pattern) {
        if (input.length() == 0 && (pattern.length() == 0 || pattern == "*")) {
            return true;
        }
        boolean M[][] = new boolean[input.length() + 1][pattern.length() + 1];
        M[0][0] = true;
        for (int i = 1; i <= input.length(); i++) {
            for (int j = 1; j <= pattern.length(); j++) {
                // case 1: letter Character.isLetter(string.charAt(index))
                 if (Character.isLetter(pattern.charAt(j - 1))) {
                    if (input.charAt(i - 1) == pattern.charAt(j - 1)) {
                        M[i][j] = M[i - 1][j - 1];
                    } else {
                        M[i][j] = false;
                    }
                }
                // case 2: ?
                else if (pattern.charAt(j - 1) == '?') {
                    M[i][j] = M[i - 1][j - 1];
                }
                // case 3: *
                else if (pattern.charAt(j - 1) == '*') {
                    int row = i;
                    while (row >= 0) {
                        if (M[row][j - 1]) {
                            M[i][j] = true;
                            break;
                        }
                        row--;
                    }
                }
            }
        }
        return M[input.length()][pattern.length()];
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.match("", "*"));
    }
}

