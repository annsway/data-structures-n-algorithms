/*
Repeatedly remove all adjacent, repeated characters in a given string from left to right.

No adjacent characters should be identified in the final string.

Examples

"abbbaaccz" → "aaaccz" → "ccz" → "z"
"aabccdc" → "bccdc" → "bdc"
*/

public class Solution{
    public String deDup(String input) {
        if (input == null || input.length() <= 1) {
            return input;
        }
        char[] array = input.toCharArray();
        int slow = 0;
        for (int fast = 1; fast < array.length; fast++) {
            if (slow == -1 || array[slow] != array[fast]) {
                array[++slow] = array[fast];
            } else {
                slow--;
                while (fast + 1 < array.length && array[fast] == array[fast + 1]) {
                    fast++;
                }
            }
        }
        return new String(array, 0, slow + 1);
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.deDup("aa"));
    }
}

