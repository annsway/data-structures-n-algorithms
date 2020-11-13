/*
Given a string with no duplicate characters, return a list with all permutations of the string and all its subsets.



Examples

Set = “abc”, all permutations are [“”, “a”, “ab”, “abc”, “ac”, “acb”, “b”, “ba”, “bac”, “bc”, “bca”, “c”, “cb”, “cba”, “ca”, “cab”].

Set = “”, all permutations are [“”].

Set = null, all permutations are [].
*/
public class Solution {
  public List<String> allPermutationsOfSubsets(String set) {
    // Write your solution here
    List<String> res = new ArrayList<>();
    if (set == null) {
      return res; 
    }
    char[] array = set.toCharArray();
    dfs(array, res, 0);
    return res; 
  }
  private void dfs(char[] array, List<String> res, int level) {
    // every state matters
    // each level represents a position 
    res.add(new String(array, 0, level));
    for (int i = level; i < array.length; i++) {
      swap(array, i, level);
      dfs(array, res, level + 1);
      swap(array, i, level);
    }
  }
  private void swap(char[] array, int i, int j) {
    char temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}
/*
                      abc
                     / | \
level 0:        (a)bc
               /    \
level 1:   a(b)c    a(c)b
            |         |
level 2:  ab(c)     ac(b)

*/