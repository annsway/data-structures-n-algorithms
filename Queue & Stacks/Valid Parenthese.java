/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid. The brackets must close in the correct order.

Examples

"()" and "()[]{}", "[{()}()]" are all valid but "(]" and "([)]" are not.
*/
public boolean isValid(String input) {
    // Write your solution here
    if (input == null || input.length() == 0) {
        return false;
    }
    char[] array = input.toCharArray();
    Deque<Character> stack = new ArrayDeque<>();
    for (int i = 0; i < array.length; i++) {
        if (array[i] == ')') {
            if (!stack.isEmpty() && stack.peekFirst() == '(') {
                stack.pollFirst();
            } else {
                return false;
            }
        } else if (array[i] == ']') {
            if (!stack.isEmpty() && stack.peekFirst() == '[') {
                stack.pollFirst();
            } else {
                return false;
            }
        } else if (array[i] == '}') {
            if (!stack.isEmpty() && stack.peekFirst() == '{') {
                stack.pollFirst();
            } else {
                return false;
            }
        } else {
            stack.offerFirst(array[i]);
        }
    }
    if (stack.isEmpty()) {
        return true;
    } else {
        return false;
    }
}
