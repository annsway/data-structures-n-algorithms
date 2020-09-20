/*
Word “book” can be abbreviated to 4, b3, b2k, etc. Given a string and an abbreviation, return if the string matches the abbreviation.

Assumptions:

The original string only contains alphabetic characters.
Both input and pattern are not null.
Pattern would not contain invalid information like "a0a","0".
Examples:

pattern “s11d” matches input “sophisticated” since “11” matches eleven chars “ophisticate”.
*/

// Tail recursion 

public class Solution{
    public boolean match(String input, String pattern) {
        if (input == null || pattern == null) {
            return false;
        }
        return helper(input, pattern, 0, 0);
    }
    private boolean helper(String str, String pat, int strIndex, int patIndex) {
        // return true only if we run out of str and pat at the same time
        // 当strIndex 和 patIndex 同时走到尽头的时候才 return true
        if (strIndex == str.length() && patIndex == pat.length()) {
            return true;
        }
        if (strIndex >= str.length() || patIndex >= pat.length()) {
            return false;
        }
        // case 1 - the current pattern position is a character
        if (pat.charAt(patIndex) < '0' || pat.charAt(patIndex) > '9') {
            if (pat.charAt(patIndex) == str.charAt(strIndex)) {
                return helper(str, pat, strIndex + 1, patIndex + 1);
            }
            return false;
        }
        // case 2 - the current pattern position is a digit
        int carry = 0;
        // Find all the digits and convert them into a number
        while (patIndex < pat.length() && pat.charAt(patIndex) >= '0' && pat.charAt(patIndex) <= '9') {
            carry = carry * 10 + pat.charAt(patIndex) - '0';
            patIndex++;
        }
        return helper(str, pat, strIndex + carry, patIndex);

    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.match("thisisatest", "t10"));
    }

}

