public class Solution {
  public int findElement(int[][] matrix, int k) {
    // Write your solution here
    if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
      return -1;
    }
    int row = k / matrix[0].length;
    int col = k % matrix[0].length;
    return matrix[row][col];

  }
}