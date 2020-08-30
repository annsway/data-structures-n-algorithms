public class Solution {
  public int longest(int[] array) {
    // Write your solution here
    int[] M = new int[array.length];
    int globalMax = 0; 
    // M[i]: the number of the longest consecutive 1s from index 0 to i
    // i     0  1  2  3  4  5  6
    //       0, 1, 0, 1, 1, 1, 0
    // M[i]  0  1  0  1  2  3  0 
    // gm:   0  1  1  1  2  3  3 
    for (int i = 0; i < array.length; i++) {
      if (array[i] == 1) {
        if (i == 0 || array[i - 1] == 0) {
          M[i] = 1;
        } else {
          M[i] = M[i - 1] + 1;
        }
      } else {
        M[i] = 0;
      }
      globalMax = Math.max(globalMax, M[i]);
    }
    return globalMax; 
  }
}