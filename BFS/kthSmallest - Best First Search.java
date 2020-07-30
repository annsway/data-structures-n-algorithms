/**
Given a matrix of size N x M. For each row the elements are sorted in ascending order, and for each column the elements are also sorted in ascending order. Find the Kth smallest number in it.

Assumptions

the matrix is not null, N > 0 and M > 0
K > 0 and K <= N * M
Examples

{ {1,  3,   5,  7},

  {2,  4,   8,   9},

  {3,  5, 11, 15},

  {6,  8, 13, 18} }

the 5th smallest number is 4
the 8th smallest number is 6

Best First Search (BFS 2) 经典例题

- 每个row 单调递增
- 每个column 单调递增
- 每个node向右边+下边expand 

{ {1 - 3,   5,  7},
    |
  {2 - 4,   8,   9},
    |
  {3,  5, 11, 15},

  {6,  8, 13, 18} }
    
    - 用一个boolean matrix来去重
    
F, F, F, F
F, F, F, F
F, F, F, F
F, F, F, F

**/

public class Solution {
  public int kthSmallest(int[][] matrix, int k) {
      int rows = matrix.length;
      int columns = matrix[0].length;
      PriorityQueue<Cell> minHeap = new PriorityQueue<Cell>(k, new Comparator<Cell>() {
          @Override
          public int compare(Cell c1, Cell c2) {
              if (c1.value == c2.value) {
                  return 0;
              }
              return c1.value < c2.value ? -1 : 1;
          }
      });

      boolean[][] visited = new boolean[rows][columns];
      minHeap.offer(new Cell(0, 0, matrix[0][0]));
      visited[0][0] = true;
      for (int i = 0; i < k - 1; i++) {
          Cell cur = minHeap.poll();
          if (cur.row + 1 < rows && !visited[cur.row + 1][cur.column]) {
              minHeap.offer(new Cell(cur.row + 1, cur.column, matrix[cur.row + 1][cur.column]));
              visited[cur.row + 1][cur.column] = true;
          }
          if (cur.column + 1 < columns && !visited[cur.row][cur.column + 1]) {
              minHeap.offer(new Cell(cur.row, cur.column + 1, matrix[cur.row][cur.column + 1]));
              visited[cur.row][cur.column + 1] = true;
          }
      }
      return minHeap.peek().value;

  }

  static class Cell {
      int row;
      int column;
      int value;

      Cell(int row, int column, int value) {
          this.row = row;
          this.column = column;
          this.value = value;
      }
  }

}
