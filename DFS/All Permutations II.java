/*
Key points: 
1. 用 HashSet 去重
2. 每个字母input[i] 只能在同一个level出现一次，但是在同一叉(path)可以重复出现

Given a string with possible duplicate characters, return a list with all permutations of the characters.

Examples

Set = “abc”, all permutations are [“abc”, “acb”, “bac”, “bca”, “cab”, “cba”]
Set = "aba", all permutations are ["aab", "aba", "baa"]
Set = "", all permutations are [""]
Set = null, all permutations are []
*/

import java.util.*;

public class Solution{
    public List<String> permutations(String input) {
        // Write your solution here
        List<String> res = new ArrayList<>();
        if (input == null) {
            return res;
        }
        char[] array = input.toCharArray();
        helper(array, 0, res);
        return res;
    }
    private void helper(char[] input, int level, List<String> res) {
        if (input.length == level) {
            res.add(new String(input));
            return;
        }
        Set<Character> set = new HashSet<>();
        for (int i = level; i < input.length; i++) { // 遍历input里的字母
            if (set.add(input[i])) { // input[i]代表字母
                swap(input, i, level);
                helper(input, level + 1, res);
                swap(input, i, level);
            }
        }
    }
    private void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.permutations("abb"));
    }
}
