/*
Given a set of characters represented by a String, return a list containing all subsets of the characters whose size is K.

Assumptions

There are no duplicate characters in the original set.

​Examples

Set = "abc", K = 2, all the subsets are [“ab”, “ac”, “bc”].

Set = "", K = 0, all the subsets are [""].

Set = "", K = 1, all the subsets are [].
*/

// TC: O(2^n)
// SC: O(n)

import java.util.ArrayList;
import java.util.List;

public class Solution{
    public List<String> subSetsOfSizeK(String set, int k) {
        // Write your solution here
        List<String> res = new ArrayList<>();
        if (set == null) {
            return res;
        }
        StringBuilder sb = new StringBuilder();
        char[] input = set.toCharArray();
        helper(input, 0, sb, res, k);
        return res;
    }
    private void helper(char[] input, int level, StringBuilder sb, List<String> res, int k) {
        if (sb.length() == k) {
            res.add(sb.toString());
            return;
        } else if (level == input.length) {
            return;
        }
        sb.append(input[level]);
        helper(input, level + 1, sb, res, k);
        sb.deleteCharAt(sb.length() - 1);
        helper(input, level + 1, sb, res, k);
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.subSetsOfSizeK("abc", 2));
    }

}
