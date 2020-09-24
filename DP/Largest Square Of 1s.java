public class Solution{
    public int largest(int[][] matrix) {
        // Write your solution here
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int N = matrix.length;
        int result = 0;
        int[][] largest = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0;  j < N; j++) {
                if (i == 0 || j == 0) {
                    if (matrix[i][j] == 1) {
                        largest[i][j] = 1;
                    }
                } else if (matrix[i][j] == 1) {
                    largest[i][j] = Math.min(largest[i - 1][j - 1] + 1, largest[i - 1][j] + 1);
                    largest[i][j] = Math.min(largest[i][j - 1] + 1, largest[i][j]);
                }
                result = Math.max(result, largest[i][j]);
            }
        }
        return result;
    }
    /* largest[][]:
     {1,1,1,1}
    ,{1,2,2,0}
    ,{1,2,3,1}
    ,{1,2,0,1}
    * */
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] matrix = {
                 {1,1,1,1}
                ,{1,1,1,0}
                ,{1,1,1,1}
                ,{1,1,0,1}
        };
        System.out.println(sol.largest(matrix));
    }

}

