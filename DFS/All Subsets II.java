/*
Given a set of characters represented by a String, return a list containing all subsets of the characters. Notice that each subset returned will be sorted to remove the sequence.

Assumptions

There could be duplicate characters in the original set.
​Examples

Set = "abc", all the subsets are ["", "a", "ab", "abc", "ac", "b", "bc", "c"]
Set = "abb", all the subsets are ["", "a", "ab", "abb", "b", "bb"]
Set = "abab", all the subsets are ["", "a", "aa","aab", "aabb", "ab","abb","b", "bb"]
Set = "", all the subsets are [""]
Set = null, all the subsets are []
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution{
    public List<String> subSets(String set) {
        // Write your solution here.
        List<String> res = new ArrayList<>();
        if (set == null || set.length() == 0) {
            return res;
        }
        char[] array = set.toCharArray();
        Arrays.sort(array);
        StringBuilder sb = new StringBuilder();
        helper(array, sb,0, res);
        return res;
    }
    private void helper(char[] input, StringBuilder sb, int level, List<String> res) {
        // base case
        if (level == input.length) {
            res.add(sb.toString());
            return;
        }
        sb.append(input[level]);
        helper(input, sb, level + 1, res);
        // de-duplicate
        while (level < input.length - 1 && input[level] == input[level + 1]) {
            level++;
        }
        sb.deleteCharAt(sb.length() - 1);
        helper(input, sb, level + 1, res);
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.subSets("abb"));
    }

}
