/*Given an array of names, determine if it is possible to arrange the students at the round table in this way.

Input: an array of names. Each name contains capital letters only.
Output: true or false.

Example
Input: String[] = {“ALICE”, “CHARLES”, “ERIC”, “SOPHIA”}
Output: true
*/
public boolean isLoop(String[] input) {
    if (input == null || input.length <= 1) {
        return false;
    }
    return helper(input, 1); // we don't need to check the first string
}
private boolean helper(String[] input, int level) {
    // base case
    if (level == input.length) {
        return canConnect(input[level - 1], input[0]); // check if the last string can be connected to the first string
    }
    for (int i = level; i < input.length; i++) {
        if (canConnect(input[level - 1], input[i])) {
            swap(input, level, i);
            if (helper(input, level + 1)) { // ** if there's a path is able to loop through the last element, then we don't need to check other paths.
                return true;
            }
            swap(input, level, i);
        }
    }
    return false;
}
private boolean canConnect(String one, String two) {
    return one.charAt(one.length() - 1) == two.charAt(0);
}
private void swap(String[] array, int i, int j) {
    String temp = array[i];
    array[i] = array[j];
    array[j] = temp;
}