public class Solution {
  public int editDistance(String one, String two) {
    // M[i][j] represents the min # of actions to transform the first i letters of S1 to 
    // the first j letters of S2
    // i represents 
    // j represents 
    int[][] M = new int[one.length() + 1][two.length() + 1];

    for (int i = 0; i <= one.length(); i++) {
        for (int j = 0; j <= two.length(); j++) {
            if (i == 0) { // base case: one[i] == null
                M[i][j] = j;
            } else if (j == 0) { // base case: two[i] == null
                M[i][j] = i;
            } else if (one.charAt(i - 1) == two.charAt(j - 1)) { // 因为M[0][0] = 0，这两个在M里往后移了一位
                M[i][j] = M[i - 1][j - 1]; 
            } else {
                M[i][j] = Math.min(M[i - 1][j - 1], Math.min(M[i - 1][j], M[i][j - 1])) + 1;
            }
        }
    }
    return M[one.length()][two.length()];
  }
}
