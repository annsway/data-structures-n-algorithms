public class Solution {
  public List<Integer> spiral(int[][] matrix) {
    List<Integer> res = new ArrayList<>();
    if (matrix == null || matrix.length == 0) {
      return res; 
    }
    helper(matrix, 0, matrix.length, res);
    return res; 
  }
  private void helper(int[][] matrix, int offset, int size, List<Integer> res) {
    // base case 
    if (size == 0) {
      return;
    }
    if (size == 1) {
      res.add(matrix[offset][offset]);
      return;
    }
    // offset 物理意义：剥了第几层洋葱
    // size 物理意义：当前的matrix有几行/列
    // i 物理意义：遍历当前行/列
    // offset + size - 1 = start + length - 1 // -1是因为从index 0 开始
    //top
    for (int i = 0; i < size - 1; i++) {
      res.add(matrix[offset][offset + i]);
    }
    //right
    for (int i = 0; i < size - 1; i++) {
      res.add(matrix[offset + i][offset + size - 1]);
    }
    //buttom
    for (int i = size - 1; i >= 1; i--) {
      res.add(matrix[offset + size - 1][offset + i]);
    }
    //left
    for (int i = size - 1; i >= 1; i--) {
      res.add(matrix[offset + i][offset]);
    }
    helper(matrix, offset + 1, size - 2, res);
  }
}
