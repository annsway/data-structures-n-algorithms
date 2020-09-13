import java.util.*;
/*
Find all occurrence of anagrams of a given string s in a given string l. Return the list of starting indices.

Assumptions

sh is not null or empty.
lo is not null.
Examples

l = "abcbac", s = "ab", return [0, 3] since the substring with length 2 starting from index 0/3 are all anagrams of "ab" ("ab", "ba").

----------------
Anagram 的意思：回文。但不一定要一一对应全部反着来。e.g. "silent" = "listen" 也属于回文。

test case: ["aab","ababacbbaac"]

Expected: [[0, 2, 7]]

*/
public class Solution{
    public List<Integer> allAnagrams(String sh, String lo) {
        // Write your solution here
        char[] array = lo.toCharArray();
        int n = sh.length();
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> shortMap = toMap(sh);
        for (int i = 0; i < array.length; i++) {
            if (i + n > lo.length()) {
                break;
            } else if (isAnagram(shortMap, toMap(lo.substring(i, i + n)))) {
                res.add(i);
            }
        }
        return res;
    }
    private boolean isAnagram(Map<Character, Integer> shortMap, Map<Character, Integer> longMap) {
        for (Map.Entry<Character, Integer> entry : shortMap.entrySet()) {
            if (!longMap.containsKey(entry.getKey()) || entry.getValue() != longMap.get(entry.getKey())) {
                return false;
            }
        }
        return true;
    }
    private Map<Character, Integer> toMap(String str) {
        Map<Character, Integer> res = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (res.containsKey(str.charAt(i))) {
                res.replace(str.charAt(i), res.get(str.charAt(i)) + 1);
            } else {
                res.put(str.charAt(i), 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.allAnagrams("aab","ababacbbaac"));
    }
}

