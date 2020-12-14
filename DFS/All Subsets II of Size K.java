/*
Given a set of characters represented by a String, return a list containing all subsets of the characters whose size is K. Notice that each subset returned will be sorted for deduplication.

Assumptions

There could be duplicate characters in the original set.


Examples

Set = "abc", K = 2, all the subsets are [“ab”, “ac”, “bc”].

Set = "abb", K = 2, all the subsets are [“ab”, “bb”].

Set = "abab", K = 2, all the subsets are [“aa”, “ab”, “bb”].

Set = "", K = 0, all the subsets are [""].

Set = "", K = 1, all the subsets are [].

Set = null, K = 0, all the subsets are [].

TC: O(2^n)
SC: O(n)

*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution{
    public List<String> subSetsIIOfSizeK(String set, int k) {
        // Write your solution here
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        char[] array = set.toCharArray();
        Arrays.sort(array); // must have for de-dup
        dfs(array, 0, k, sb, res);
        return res;
    }
    private void dfs(char[] array, int level, int k, StringBuilder sb, List<String> res) {
        // base case
        if (level == array.length) {
            if (sb.length() == k) {
                res.add(new String(sb));
            }
            return;
        }
        sb.append(array[level]);
        dfs(array, level + 1, k, sb, res);
        // de-duplicate
        while (level + 1 < array.length && array[level] == array[level + 1]) {
            level++;
        }
        sb.deleteCharAt(sb.length() - 1);
        dfs(array, level + 1, k, sb, res);
    }
    /*
              / \
    L0      a    ""
           /    / \
    L1   ab     b
    ...  /     /
    Lk (abb)  bb

    */
    public static void main(String[] args) {
        Solution sol = new Solution();
        String array = "bab";
        // Expected: [["ab", "bb"]]
        System.out.println(sol.subSetsIIOfSizeK(array, 2));
    }
}

