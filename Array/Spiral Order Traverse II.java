public class Solution {
  public List<Integer> spiral(int[][] matrix) {
    // Write your solution here
    List<Integer> res = new ArrayList<>();
    if (matrix == null || matrix.length == 0) {
      return res; 
    }
    helper(matrix, 0, matrix.length, matrix[0].length, res);
    return res; 
  }
  private void helper(int[][] matrix, int offset, int rows, int columns, List<Integer> res) {
    if (rows == 0 || columns == 0) { // 空馒头，没有肉馅儿. e.g. 5 x 2 matrix 转一圈就够了，第一圈之后就不能往里走了
      return;
    }
    if (rows == 1 && columns == 1) {
      res.add(matrix[offset][offset]);
      return;
    }
    if (rows == 1) { // 当只剩一排，遍历这一排的所有element，注意不要 -1
      for (int i = 0; i < columns; i++) {
        res.add(matrix[offset][offset + i]);
      }
      return; 
    }
    if (columns == 1) { // 当只剩一列，遍历这一列的所有element，注意不要 -1
      for (int i = 0; i < rows; i++) {
        res.add(matrix[offset + i][offset + columns - 1]);
      }
      return; 
    }
    for (int i = 0; i < columns - 1; i++) {
      res.add(matrix[offset][offset + i]);
    }
    for (int i = 0; i < rows - 1; i++) {
      res.add(matrix[offset + i][offset + columns - 1]);
    }
    for (int i = columns - 1; i >= 1; i--) {
      res.add(matrix[offset + rows - 1][offset + i]);
    }
    for (int i = rows - 1; i >= 1; i--) {
      res.add(matrix[offset + i][offset]);
    }
    helper(matrix, offset + 1, rows - 2, columns - 2, res);
  }
}
