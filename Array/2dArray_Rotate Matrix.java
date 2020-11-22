/*
Rotate an N * N matrix clockwise 90 degrees.

Assumptions

The matrix is not null and N >= 0
Examples

{ {1,  2,  3}

  {8,  9,  4},

  {7,  6,  5} }

after rotation is

{ {7,  8,  1}

  {6,  9,  2},

  {5,  4,  3} }
*/
public class Solution{
    public void rotate(int[][] matrix) {
        // Write your solution here
        int n = matrix.length;
        if (n <= 1) {
            return;
        }
        mirrorY(matrix, n);
        print(matrix);
        System.out.println();
        mirrorYEX(matrix, n);
    }
    // mirror EVERY cell by y axis, that is, reverse each ROW
    private void mirrorY(int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                swap(matrix, i, j, i, n - 1 - j); // n - 1 - j is the distance between column 0 and current column
            }
        }
    }
    // mirror EVERY cell by y = x
    private void mirrorYEX(int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1 - i; j++) { // 只能swap左上部分，否则又swap回原形。
                swap(matrix, i, j, n - 1 - j, n - 1 - i);
//                System.out.println("YEX: ("+i+","+j+")\n");
//                print(matrix);
//                System.out.println();
            }
        }
    }
    private void swap(int[][] matrix, int irow, int icol, int jrow, int jcol) {
        int temp = matrix[irow][icol];
        matrix[irow][icol] = matrix[jrow][jcol];
        matrix[jrow][jcol] = temp;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        sol.print(matrix);
        System.out.println();
        sol.rotate(matrix);
        sol.print(matrix);
    }
    private void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println("");
        }
    }
}

