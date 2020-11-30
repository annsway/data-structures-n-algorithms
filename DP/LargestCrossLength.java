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
        int[][] leftUp = leftUp(matrix, n, m);
        int[][] rightDown = rightDown(matrix, n, m);
        return merge(leftUp, rightDown, n, m);
    }
    private int[][] leftUp(int[][] matrix, int n, int m) {
        int[][] leftArm = new int[n][m];
        int[][] upArm = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) { // otherwise, default value is 0
                    if (i == 0 && j == 0) { // otherwise, NPE
                        leftArm[i][j] = 1;
                        upArm[i][j] = 1;
                    } else if (j == 0) {
                        leftArm[i][j] = 1;
                        upArm[i][j] = upArm[i - 1][j] + 1; // must update upArm[i][j] here, otherwise it won't get into last 'else' to update upArm[i][j]
                    } else if (i == 0) {
                        upArm[i][j] = 1;
                        leftArm[i][j] = leftArm[i][j - 1] + 1;
                    } else {
                        leftArm[i][j] = leftArm[i][j - 1] + 1;
                        upArm[i][j] = upArm[i - 1][j] + 1;
                    }
                }
            }
        }
        merge(leftArm, upArm, n, m);
        return leftArm;
    }
    private int[][] rightDown(int[][] matrix, int n, int m) {
        int[][] rightArm = new int[n][m];
        int[][] downArm = new int[n][m];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (matrix[i][j] == 1) { // otherwise, default value is 0
                    if (i == n - 1 && j == m - 1) {
                        rightArm[i][j] = 1;
                        downArm[i][j] = 1;
                    } else if (j == m - 1) {
                        rightArm[i][j] = 1;
                        downArm[i][j] = downArm[i + 1][j] + 1;
                    } else if (i == n - 1) {
                        downArm[i][j] = 1;
                        rightArm[i][j] = rightArm[i][j + 1] + 1;
                    } else {
                        rightArm[i][j] = rightArm[i][j + 1] + 1;
                        downArm[i][j] = downArm[i + 1][j] + 1;
                    }
                }
            }
        }
        merge(rightArm, downArm, n, m);
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

