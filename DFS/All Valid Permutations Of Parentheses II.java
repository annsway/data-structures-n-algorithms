/*
Get all valid permutations of l pairs of (), m pairs of <> and n pairs of {}.

Assumptions

l, m, n >= 0
l + m + n > 0
Examples

l = 1, m = 1, n = 0, all the valid permutations are ["()<>", "(<>)", "<()>", "<>()"]

*/
import java.util.*;

public class Solution{
    private final char[] PS = {'(', ')', '<', '>', '{', '}'};
    public List<String> validParentheses(int l, int m, int n) {
        List<String> res = new ArrayList<>();
        int[] remain = {l, l, m, m, n, n};
        int targetLen = l * 2 + m * 2 + n * 2;   // used for base case
        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        helper(sb, stack, targetLen, remain, res);
        return res;
    }
    private void helper(StringBuilder sb, Deque<Character> stack, int targetLen, int[] remain, List<String> res) {
        if (sb.length() == targetLen) {
            res.add(sb.toString());
            return;
        }
        for (int i = 0; i < remain.length; i++) { // ****
            if (i % 2 == 0) {
                if (remain[i] > 0) {
                    sb.append(PS[i]); // 左括号
                    stack.offerFirst(PS[i]);
                    remain[i]--;
                    helper(sb, stack, targetLen, remain, res);
                    sb.deleteCharAt(sb.length() - 1);
                    stack.pollFirst();
                    remain[i]++;
                }
            } else { // 栈顶元素是否是前一个左括号
                if (!stack.isEmpty() && stack.peekFirst() == PS[i - 1]) {
                    sb.append(PS[i]);
                    stack.pollFirst();
                    remain[i]--;
                    helper(sb, stack, targetLen, remain, res);
                    sb.deleteCharAt(sb.length() - 1);
                    stack.offerFirst(PS[i - 1]);
                    remain[i]++;
                }
            }
        }
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.validParentheses(2, 1, 1));
    }
}
