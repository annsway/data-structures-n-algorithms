/** Remove adjacent, repeated characters in a given string, leaving only one character for each group of such characters.

Assumptions

Try to do it in place.
Examples

“aaaabbbcaa” is transferred to “abc”
Corner Cases

If the given string is null, returning null or an empty string are both valid.
**/

public String deDup(String input) {
    // Write your solution here
    if (input == null) {
        return null;
    }
    int slow = 0;
    char[] array = input.toCharArray();
    Set<Character> set = new HashSet<>();
    for (int fast = 0; fast < array.length; fast++) {
        if (!set.contains(array[fast])) {
            array[slow++] = array[fast];
            set.add(array[fast]);
        } 
    }
    return new String(array, 0, slow);
}