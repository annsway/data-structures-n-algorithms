/**
Remove given characters in input string, the relative order of other characters should be remained. Return the new string after deletion.

Assumptions

The given input string is not null.
The characters to be removed is given by another string, it is guaranteed to be not null.
Examples

input = "abcd", t = "ab", delete all instances of 'a' and 'b', the result is "cd".
**/
import java.util.*;

public class Solution{
    public String remove(String input, String t) {
        // Write your solution here
        char[] inputArray = input.toCharArray();
        Set<Character> tSet = buildSet(t);
        int slow = 0;
        for (int fast = 0; fast < inputArray.length; fast++) {
            if (!tSet.contains(inputArray[fast])) {
                inputArray[slow] = inputArray[fast]; // In-place: replace the original input array with the answer
                slow++;
            }
        }
        System.out.println(inputArray); // the original array has changed. 
        return new String(inputArray, 0, slow);
        // String Constructor: String(byte[] bytes, int offset, int length)
        // offset: the first index to use from an array.

    }
    private Set<Character> buildSet(String s) {
        char[] sArray = s.toCharArray();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < sArray.length; i++) {
            //if (!sArray.contains(sArray[i])) // Don't need it, since HashSet won't add duplicate to a itself
            set.add(sArray[i]);
        }
        return set;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
//        int[] a = {1, 3, 5, 3};
//        int[] b = {4, 8, 3, 3};
        String a = "abcd";
        String b = "abd";

        System.out.println(sol.remove(a, b));
    }

}