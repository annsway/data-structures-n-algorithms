public class Solution {
  public int editDistance(String one, String two) {
    // M[i][j] represents the min # of actions to transform the first i letters of S1 to the first j letters of S2
    // i represents the ith letter of S1, 对应的S1 index = i - 1
    // j represents the jth letter of S2, 对应的S2 index = j - 1
    int[][] M = new int[one.length() + 1][two.length() + 1];

    for (int i = 0; i <= one.length(); i++) {
        for (int j = 0; j <= two.length(); j++) {
            if (i == 0) { // base case: one[i] == null
                M[i][j] = j;
            } else if (j == 0) { // base case: two[i] == null
                M[i][j] = i;
            } else if (one.charAt(i - 1) == two.charAt(j - 1)) { // 因为M[0][0] = 0，这两个在M里往后移了一位
                M[i][j] = M[i - 1][j - 1]; // M[i - 1][j - 1] represents the state where no new character was added. 
            } else {
                M[i][j] = Math.min(M[i - 1][j - 1], Math.min(M[i - 1][j], M[i][j - 1])) + 1;
            }
        }
    }
    return M[one.length()][two.length()];
  }
}
/* Example: 
String one = "sigh"
String two = "asith"

   j 0 1 2 3 4 5
i   ”“ a s i t h
0 ”“ 0 1 2 3 4 5  
1  s 1 1 1 2 3 4
2  i 2 2 2 1 2 3
3  g 3 3 3 2 2 3
4  h 4 4 4 3 3 2

*/