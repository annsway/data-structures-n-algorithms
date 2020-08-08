/**
Given a string, remove all leading/trailing/duplicated empty spaces.

Assumptions:

The given string is not null.
Examples:

“  a” --> “a”
“   I     love MTV ” --> “I love MTV”
**/  

public String removeSpaces(String input) {
    // Write your solution here
    char[] array = input.toCharArray();
    int slow = 0;
    for (int fast = 0; fast < array.length; fast++) {
        // case 1: array[]
        if (array[fast] != ' ') {
            array[slow++] = array[fast]; // 换letter
        } else {
            if (slow == 0 || array[slow - 1] == ' ') { // 第一位是space，或者前面已有一个space, 那么不换space
                continue;
            } else {
                array[slow++] = array[fast]; // 换space
            }
        }
    }
    if (slow > 0 && array[slow - 1] == ' ') {
        slow--;
    }
    return new String(array, 0, slow);
}