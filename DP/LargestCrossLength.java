/*
Given a matrix that contains only 1s and 0s, find the largest cross which contains only 1s, with the same arm lengths and the four arms joining at the central point.

Return the arm length of the largest cross.

Assumptions

The given matrix is not null, has size of N * M, N >= 0 and M >= 0.
Examples

{ {0, 0, 0, 0},

  {1, 1, 1, 1},

  {0, 1, 1, 1},

  {1, 0, 1, 1} }

the largest cross of 1s has arm length 2.
*/

public class Solution{
    public int largestCrossLength(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        if (n == 0 || m == 0) {
            return 0;
        }
        int[][] leftUpper = leftUpper(matrix, n, m);
        int[][] rightLower = rightLower(matrix, n, m);
        return merge(leftUpper, rightLower, n, m);
    }
    private int[][] leftUpper(int[][] matrix, int n, int m) {
        int[][] leftArm = new int[n][m];
        int[][] upperArm = new int[n][m];
        /**
         M[i][j] represents the maximum length of a consecutive 1s in the M direction 
         **/
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) { // otherwise, default value is 0
                    if (i == 0 && j == 0) { // otherwise, NPE
                        leftArm[i][j] = 1;
                        upperArm[i][j] = 1;
                    } else if (j == 0) {
                        leftArm[i][j] = 1;
                        upperArm[i][j] = upperArm[i - 1][j] + 1; // must update upperArm[i][j] here, otherwise it won't get into last 'else' to update upperArm[i][j]
                    } else if (i == 0) {
                        upperArm[i][j] = 1;
                        leftArm[i][j] = leftArm[i][j - 1] + 1;
                    } else {
                        leftArm[i][j] = leftArm[i][j - 1] + 1;
                        upperArm[i][j] = upperArm[i - 1][j] + 1;
                    }
                }
            }
        }
        merge(leftArm, upperArm, n, m);
        return leftArm;
    }
    private int[][] rightLower(int[][] matrix, int n, int m) {
        int[][] rightArm = new int[n][m];
        int[][] lowerArm = new int[n][m];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (matrix[i][j] == 1) { // otherwise, default value is 0
                    if (i == n - 1 && j == m - 1) {
                        rightArm[i][j] = 1;
                        lowerArm[i][j] = 1;
                    } else if (j == m - 1) {
                        rightArm[i][j] = 1;
                        lowerArm[i][j] = lowerArm[i + 1][j] + 1;
                    } else if (i == n - 1) {
                        lowerArm[i][j] = 1;
                        rightArm[i][j] = rightArm[i][j + 1] + 1;
                    } else {
                        rightArm[i][j] = rightArm[i][j + 1] + 1;
                        lowerArm[i][j] = lowerArm[i + 1][j] + 1;
                    }
                }
            }
        }
        merge(rightArm, lowerArm, n, m);
        return rightArm;
    }
    private int merge(int[][] one, int[][] two, int n, int m) {
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                one[i][j] = Math.min(one[i][j], two[i][j]);
                result = Math.max(result, one[i][j]);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[][] matrix = { {0, 0, 0, 0},
                            {1, 1, 1, 1},
                            {0, 1, 1, 1},
                            {1, 0, 1, 1} };
        Solution sol = new Solution();
        System.out.println(sol.largestCrossLength(matrix));;
    }

}


