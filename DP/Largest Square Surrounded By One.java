/*
Determine the largest square surrounded by 1s in a binary matrix (a binary matrix only contains 0 and 1), return the length of the largest square.



Assumptions

The given matrix is guaranteed to be of size M * N, where M, N >= 0



Examples

{{1, 0, 1, 1, 1},

 {1, 1, 1, 1, 1},

 {1, 1, 0, 1, 0},

 {1, 1, 1, 1, 1},

 {1, 1, 1, 0, 0}}



The largest square surrounded by 1s has length of 3.
*/
import java.util.Arrays;

public class Solution{
    public int largestSquareSurroundedByOne(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        if (matrix == null || n == 0 || m == 0) {
            return 0;
        }
        // pre-processing: the largest consecutive 1s from four directions
        int[][] leftUpper = leftUpper(matrix, n, m);
        int[][] rightLower = rightLower(matrix, n, m);
        return helper(leftUpper, rightLower, n, m);
    }
    private void print(int[][] matrix, int n, int m) {
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
    private int helper(int[][] leftUpper, int[][] rightLower, int n, int m) {
        int maxLen = 0;
//        print(leftUpper, n, m);
//        System.out.println("\n");
//        print(rightLower, n, m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int leftUpperVertex = rightLower[i][j];
                if (leftUpperVertex != 0) {
                    for (int k = 0; k < leftUpperVertex && j + k < m && i + k < n; k++) {
                        int rightLowerVertex = leftUpper[i + k][j + k];
                        if (rightLowerVertex >= k + 1) { // k + 1 是正方形的边长
                            maxLen = Math.max(maxLen, k + 1);
//                            if (maxLen == 6) {
//                                System.out.println("leftUpperVertex = " + leftUpperVertex + " rightLowerVertex = " + rightLowerVertex);
//                                System.out.println("i = "+i + " j = "+ j + " k = " + k);
//                                break;
//                            }
                        }
                    }
                }

            }
        }
        return maxLen;
    }
    private int[][] leftUpper(int[][] matrix, int n, int m) {
        int[][] leftArm = new int[n][m];
        int[][] upperArm = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) {
                    if (i == 0 && j == 0) {
                        leftArm[i][j] = 1;
                        upperArm[i][j] = 1;
                    } else if (j == 0) {
                        leftArm[i][j] = 1;
                        upperArm[i][j] = upperArm[i - 1][j] + 1;
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
                if (matrix[i][j] == 1) {
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
                        lowerArm[i][j] = lowerArm[i + 1][j] + 1;
                        rightArm[i][j] = rightArm[i][j + 1] + 1;

                    }
                }
            }
        }
        merge(rightArm, lowerArm, n, m);
        return rightArm;
    }
    private void merge(int[][] one, int[][] two, int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                one[i][j] = Math.min(one[i][j], two[i][j]);
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,1,1,0,1,1,0,1,0,1,1,1,0,0,1,1},{1,1,1,0,0,0,1,1,0,0,1,1,1,1,1,1},{1,1,0,0,1,1,0,1,0,0,1,1,1,1,1,0},{0,1,1,1,1,0,1,1,1,1,1,0,1,1,1,1},{1,1,1,1,0,1,1,0,1,1,1,0,1,0,1,1},{1,0,1,1,1,0,1,1,0,1,0,1,0,0,0,1},{1,1,1,1,1,1,0,0,1,1,1,1,0,1,1,1},{1,1,1,1,0,1,0,0,0,0,1,0,0,1,1,1},{1,1,1,1,1,1,1,0,0,1,1,0,1,1,1,1},{0,1,1,1,0,1,1,1,1,1,1,1,0,1,1,0},{1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0},{1,1,1,1,1,1,0,1,1,1,0,1,0,0,1,1},{1,0,1,1,0,1,1,1,1,0,0,1,1,0,1,0},{1,1,1,1,0,1,1,1,0,1,1,1,1,1,1,1},{1,1,1,0,1,1,0,1,0,1,1,1,0,0,1,1},{1,0,1,1,1,1,0,0,0,1,1,1,0,1,1,0},{1,0,1,0,0,1,0,1,0,0,1,1,0,1,1,1},{1,0,0,1,1,1,1,0,0,0,1,1,1,1,1,1},{1,1,0,1,1,0,1,1,1,1,1,1,0,1,1,1},{1,0,1,0,0,1,0,1,0,0,1,1,0,0,1,1},{1,0,1,1,1,0,1,1,1,1,1,1,0,1,0,1},{1,1,1,1,0,1,1,0,0,0,1,0,0,1,0,1}}
;
        Solution sol = new Solution();
        System.out.println(sol.largestSquareSurroundedByOne(matrix));;
    }

}

