/**
Given N pairs of parentheses “()”, return a list with all the valid permutations.

Assumptions

N > 0
Examples

N = 1, all valid permutations are ["()"]
N = 3, all valid permutations are ["((()))", "(()())", "(())()", "()(())", "()()()"]
**/

import java.util.ArrayList;
import java.util.List;

public class SolDFS {

    public List<String> validParentheses(int k){
        List<String> result = new ArrayList<>();
        char[] cur = new char[k*2];
        helper(cur, k, k, 0, result);
        return result;
    }

    private void helper(char[] cur, int leftRem, int rightRem, int level, List<String> result){
        if (leftRem == 0 && rightRem == 0) {
            result.add(new String(cur)); // convert char[] to String by using a String Constructor
            return;
        }
        if (leftRem > 0) {
            cur[level] = '(';
            helper(cur, leftRem - 1, rightRem, level + 1, result); // DFS
        }
        if (rightRem > leftRem) {
            cur[level] = ')';
            helper(cur, leftRem, rightRem - 1, level + 1, result); // DFS
        }
    }

    public static void main(String[] args) {
        SolDFS sol = new SolDFS();
        System.out.println(sol.validParentheses(2));
    }
}
