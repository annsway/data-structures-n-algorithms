/*
Given a matrix that contains integers, find the submatrix with the largest sum.

Return the sum of the submatrix.

Assumptions

The given matrix is not null and has size of M * N, where M >= 1 and N >= 1
Examples

{ {1, -2, -1, 4},

  {1, -1,  1, 1},

  {0, -1, -1, 1},

  {0,  0,  1, 1} }

the largest submatrix sum is (-1) + 4 + 1 + 1 + (-1) + 1 + 1 + 1 = 7.
*/
public class Solution{
    public int largest(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < rows; i++) { // 从上到下遍历每一个小长方形
            int[] cur = new int[columns]; // cur 物理意义：在这个小长方形里，每一列最大值组成的1D array
            for (int j = i; j < rows; j++) {
                flatten(cur, matrix[j]);
                result = Math.max(result, findMaxSubsequence(cur));
            }
        }
        return result;
    }
    private void flatten(int[] cur, int[] add) {
        for (int i = 0; i < cur.length; i++) {
            cur[i] += add[i];
        }
    }
    private int findMaxSubsequence (int[] cur) {
        int[] M = new int[cur.length];
        M[0] = cur[0];
        int temp = cur[0];
        for (int i = 1; i < cur.length; i++) {
            temp = Math.max(temp + cur[i], cur[i]);
            M[i] = Math.max(M[i - 1], temp);
        }
        return M[cur.length - 1];
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] matrix = {
                 {-4, 2,-1, 0, 2}
                ,{ 2, 3, 2, 1,-3}
                ,{-3,-3,-2, 2, 4}
                ,{ 1, 1, 2,-2, 5}
                ,{-4, 0, 1, 1,-4}
        };
        System.out.println(sol.largest(matrix));
    }

}

